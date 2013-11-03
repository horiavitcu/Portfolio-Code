//Searches in clipboard contents and returns true if it contains the
//specified text value.
//@textToCompare: The text to search in clipboard for
function ClipboardContains(textToCompare)
{
  var regEx, matches;
  //Get clipboard commnents
  var inStr = NameMapping.Sys.Clipboard;
  //Set regular expression pattern that specifies a phone number
  regEx = new RegExp(textToCompare, "g");
  //Try to find specified string in clipboard comments
  matches = inStr.match(regEx);
  return (matches != null) && (matches.length > 0);
}

//Verifies that clipboard contents equal the specified text.
//Logs an error if the specified text differs from clipboard contents
//@textToVerify: The text to compare clipboard contents with
function VerifyClipboardContents(textToVerify)
{
  //Get clipboard commnents
  var inStr = NameMapping.Sys.Clipboard;
   
  //Checks if clipboard contents equal expected contents
  if(aqConvert.VarToStr(inStr) != textToCompare)
  {
    //Posts an error to the test log.
    Log.Error("Did not find expected value " + textToVerify +  
              " Actual value: " + aqConvert.VarToStr(inStr));
  }
}

//Function to extract contents from clipboard based in the specified
//regular expression. It stores extracted activation code in the respective
//project suite variable.
function ExtractActivationCodeFromClipboard()
{
  var regEx, matches;
  //Get clipboard commnents
  var inStr = NameMapping.Sys.Clipboard;
  //Try to find specified string in clipboard comments
  matches = inStr.match(/[a-z,A-z,0-9]{32}/g);
  if((matches != null) && (matches.length > 0))
  {
    //Store the extracted activation code in the respective project suite variable
    ProjectSuite.Variables.ActivationCode = matches[0];
  }
  else
  {
    //Activation code not found. Store an empty string.
    ProjectSuite.Variables.ActivationCode = "";
  }
}