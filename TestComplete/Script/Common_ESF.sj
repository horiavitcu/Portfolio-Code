//-----------------------------------------------------------//
//---------------------REGULAR FUNCTIONS---------------------//
//-----------------------------------------------------------//
//This function is used to click on spesified link
//@menuPanel, spesifies the panel which includes the link
//@itemName, the 'innerText' property of the link 
function clickLink(menuPanel, itemName)
{
  var PropArray, ValuesArray, p, w; 
  // Creates arrays of property names and values   
  PropArray = new Array("ObjectType", "innerText","Visible");
  ValuesArray = new Array("Link", "*" + itemName + "*",true); 
  
  // Searches for the Object
  p = menuPanel;
  w = p.FindChild(PropArray, ValuesArray, 20000, true);
  // Checks for the spesified odject existance
  if (w.Exists)
  {
    w.Click();   
  }
  else
  {
    Log.Error("The specified panel or Link: "+ itemName +" does not exist");
  }   
}                                                 
//This function is used to click on spesified image Button (e.g 'AddIt')
//@menuPanel, spesifies the panel which includes the link
//@itemName, the 'title' property of the ImageButton 
function clickImageButton(menuPanel, itemName)
{
  var PropArray, ValuesArray, p, w; 
  // Creates arrays of property names and values   
  PropArray = new Array("ObjectType", "title","Visible");
  ValuesArray = new Array("ImageButton", itemName,true); 
  
  // Searches for the Object
  p = menuPanel;
  w = p.FindChild(PropArray, ValuesArray, 10); 
  // Checks for the spesified odjectexistance    
  if (w.Exists)
  {
    w.Click();
  }
  else
  {
    Log.Error("The specified panel or Image Button: "+ itemName +" does not exist");
  }
   
}
//This function is used to click on spesified category
//@menuPanel, spesifies the panel which includes the category
//@itemName, the 'innerText' property of the Category link 
function clickCategory(menuPanel, itemName)
{
  var PropArray, ValuesArray, p, w; 
  // Creates arrays of property names and values   
  PropArray = new Array("ObjectType", "innerText","Visible");
  ValuesArray = new Array("Link", itemName, true); 
  
  // Searches for the Object
  p = menuPanel;
  w = p.FindChild(PropArray, ValuesArray, 10); 
  // Checks for the spesified odject existance    
  if (w.Exists)
  {
    w.Click();
  }
  else
  {
    Log.Error("The specified panel or Category item: "+ itemName +" does not exist");
  }
}  

//This function is used to click on spesified SubCategory
//@menuPanel, spesifies the panel which includes the category
//@itemName, the 'innerText' property of the SubCategory link 
function clickSubCategory(menuPanel, itemName) 
{
  //split given itemName to array
  itemNameArray = itemName.split("|");
  //hover to the specified category
  hoverCategory(menuPanel, itemNameArray[0]); 
  //hover to the specified subcategory  
  hoverCategory(menuPanel, itemNameArray[1]); 
  //click to the specific subcategory link 
  clickLink(menuPanel, itemNameArray[1]);
}

//This function is used to click on spesified image Button (e.g 'AddIt') 
//which belongs to a spesified product item.
//@menuPanel, spesifies the panel which includes the link
//@itemName, the 'title' property of the link 
//@imageButtonTitle, the title of imagebutton
function clickImageButtonInProductItem(menuPanel, itemName, imageButtonTitle)
{
  var PropArray, ValuesArray, p, w; 
  // Creates arrays of property names and values   
  PropArray = new Array("ObjectType", "innerText");
  ValuesArray = new Array("Link", itemName); 
  
  // Searches for the Object
  p = menuPanel;
  w = p.FindChild(PropArray, ValuesArray, 10); 
  // Checks for the spesified odject existance
  if (w.Exists)
  {
    var parentMenuPanel= w.Parent.Parent.Parent; 
    clickImageButton(parentMenuPanel, imageButtonTitle);        
  }
  else
  {
    Log.Error("The specified panel or menu item: "+ itemName +" does not exist");
  }
   
}
 
//-----------------------------------------------------------//
//---------------------INTERNAL USAGE------------------------//
//-----------------------------------------------------------// 
//This function is for internal usage to hover on Category
//@menuPanel, spesifies the panel which includes the category
//@itemName, the 'innerText' property of the Category link 
function hoverCategory(menuPanel, itemName)
{
  var PropArray, ValuesArray, p, w; 
  // Creates arrays of property names and values   
  PropArray = new Array("ObjectType", "innerText", "Visible");
  ValuesArray = new Array("Link", "*" + itemName + "*", true); 
  
  // Searches for the Object
  p = menuPanel;
  w = p.FindChild(PropArray, ValuesArray, 10); 
  // Checks for the spesified odject existance
  if (w.Exists)
  {
    w.HoverMouse();
  }
  else
  {
    Log.Error("The specified panel or menu item: "+ itemName + " does not exist");
  }
   
}
//This function is for internal usage to hover on spesified Product
//@menuPanel, spesifies the panel which includes the product
//@itemName, the 'innerText' property of the Product link 
function hoverProduct(menuPanel, itemName)
{
  var PropArray, ValuesArray, p, w; 
  // Creates arrays of property names and values   
  PropArray = new Array("ObjectType", "innerText", "Visible");
  ValuesArray = new Array("Panel", itemName, true); 
  
  // Searches for the Object
  p = menuPanel;
  w = p.FindChild(PropArray, ValuesArray, 10); 
  // Checks for the spesified odject existance
  if (w.Exists)
  {
    w.HoverMouse();
  }
  else
  {
    Log.Error("The specified panel or menu item: "+ itemName + " does not exist");
  }   
}  
 
 