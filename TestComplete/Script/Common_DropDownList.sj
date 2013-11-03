//This function is used for selecting an item from a drop down list.
//This applied when a drop down list has text and id (e.g.  Sales  5).
//@dropDownList is the drop down list which the item belongs.
//@itemText is the text of the property text of the item we want to select. 
function selectDropDownListItemByText(dropDownList, itemText)
{
  //Check if the given values are null 
  if (itemText == null)  
  {
    Log.Error("The parameter itemText is null");  
  }
    
  //Gather entire text of the drop down list.
  var itemsStr = dropDownList.Items.Text;
  //Splits the text of the drop down list to lines.
  itemsArrayLines =  itemsStr.split("\n"); 
    
  //walkthrought in lines. 
  for (var i=0; i<itemsArrayLines.length; i++)
  {
    //Splits the line in two parts (text / index). 
    itemsArray = itemsArrayLines[i].split("\t"); 
    //Check if the given text is equals to the line's text.
    if(itemText == itemsArray[0])
    {
      //Sets the proper index.
      dropDownList.SetValue(i-1);
      return; 
    }
    else
    {
      //Checks if the number of line is the last line of text.
      if(i !== itemsArrayLines.length-1)
      { 
        continue;             
      }
      //Logs an error in case the iteration on lines did not find the given item. 
        
      else
      {
        Log.Error("The List Item: "+itemText+" you look for does not exist in the specific Drop Down List");
      }
    }
  }
}