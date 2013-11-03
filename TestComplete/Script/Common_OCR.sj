//Searches in the specified object for the specified text
//@windowObject: The object in which to search for the specified text
//@textToFind: The text to search in clipboard for
//@exactSearch: A boolean parameter specifying wheather to search for the exact text or not
//@removeWhiteSpace: A boolean parameter to determine if the before comparing text captured
//                   from window to specified, all spaced should be removed
function ImageContainsText(windowObject, textToFind, exactSearch, removeWhiteSpace)
{
  //Uses OCR technology to extract the text from the image.
  var OCRObj;
  OCRObj = OCR.CreateObject(windowObject);
  // Creates an OCROptions object
  OCROptions = OCRObj.CreateOptions();
  // Specifies that the FindRectByText method will search for exact matches
  OCROptions.ExactSearch = exactSearch;

  //Returns true if the text is found in the specified object, false otherwise.
  var capturedText = OCRObj.GetText(OCROptions);
  //Log the captured text
  Log.Message("Captured text: " + capturedText);
  if(exactSearch)
  {
    if(removeWhiteSpace == true)
    {
      Log.Message(aqString.Concat("Captured text with white space removed: ", aqString.Replace(aqConvert.VarToStr(capturedText), " ", ""))); 
      return (aqString.Replace(aqConvert.VarToStr(capturedText), " ", "") == aqString.Replace(textToFind, " ", ""));
    }
    else
    {
      return (aqConvert.VarToStr(capturedText) == textToFind);
    }
  }
  else
  {
    if(removeWhiteSpace == true)
    {
      Log.Message(aqString.Concat("Captured text with white space removed: ", aqString.Replace(aqConvert.VarToStr(capturedText), " ", ""))); 
      return (aqString.Contains(aqString.Replace(aqConvert.VarToStr(capturedText), " ", ""), aqString.Replace(textToFind, " ", ""), 0, false) != -1); 
    }
    else
    {
      return (aqString.Contains(aqConvert.VarToStr(capturedText), textToFind, 0, false) != -1);
    }
  }
}

//Clicks the specified text on the specified object.
//Uses OCR to locate the text on the object.
//If the text is found, this function clicks/rigth clicks on the object in
//the middle of the bounding rect that holds the searched text.
//@object: The object to click on
//@text: The text to search for in object and click on
//@rigthClick: If true, rigth click, otherwise just click
//exactSearch: OCR recognition parameter. If true it will try to make an
//             exact match on the searched text, otherwise a 60% match.   
function ClickTextOnObject(object, text, rigthClick, exactSearch)
{
  //Uses OCR technology to extract the text from the image.
  var OCRObj;
  OCRObj = OCR.CreateObject(object);
  // Creates an OCROptions object
  OCROptions = OCRObj.CreateOptions();
  // Specifies that the FindRectByText method will search for exact matches
  OCROptions.ExactSearch = exactSearch;

  Log.Message("Searching for " + text);
  //Returns true if the text is found in the specified object, false otherwise.
  var textFound = OCRObj.FindRectByText(text, OCROptions);
  //If the text is recognised in the object...
  if(textFound)
  {
    Log.Message("Found " + text + " in object.");
    if(rigthClick)
    {
      //Right click on object on the text found
      Log.Message("Rigth clicking on text: " + text);
      object.ClickR(OCRObj.FoundX, OCRObj.FoundY, 0);
    }
    else
    {
      //Click on object on text found
      Log.Message("Clicking on text: " + text);
      object.Click(OCRObj.FoundX, OCRObj.FoundY, 0);
    }
  }
}