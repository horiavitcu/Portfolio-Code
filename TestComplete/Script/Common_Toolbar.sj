//-----------------------------------------------------------//
//---------------------REGULAR FUNCTIONS---------------------//
//-----------------------------------------------------------//

//Use this function to click open the menu/submenu item in toolbar
//Can be used on menu with multiple levels of submenus
//@menuObj: The toolbar object of type TdxBarControl class 
//@menuItems: The captions of the menu and submenus in string format. 
//            Use '|' separator to separate levels of submenu
//            E.g. clickMenuItem(menuObj, "Accounting|US Payroll|Payroll Items")
function clickMenuItem(menuObj, menuItems)
{
  var arrstr, len, counter, counter2, found;
  if(menuObj!=null && menuItems!=null && menuItems!="")
  { 
    //Storing the original parameter into a variable
    param_menuObj = menuObj;
    //split menuitems into array based on | as delimiter
    arrstr = menuItems.split("|");
    for(counter=0;counter<arrstr.length;counter++)
    {
      found = false;
      for(counter2=0;counter2<menuObj.ItemLinks.Count;counter2++)
      //search for the menu/submenu
      if(removeAmpersand(menuObj.ItemLinks.Items(counter2).Caption)==arrstr[counter])
      {
        //pointing to the found menu object
        
        menuObj = menuObj.ItemLinks.Items(counter2).Item;
        found = true;
        break;      
      }
    }
    //use Runner.CallObjectMethodAsync to handle modal object
    //click on the final sub-menu
    if(found&&isMenuItemEnabled(param_menuObj, menuItems))
    {
      Runner.CallObjectMethodAsync(menuObj,"Click");
      Log.Message("Click on menu(s): "+menuItems);
    }
    else   
      Log.Error("Menu(s) not found: "+menuItems);
  }
  else
  {
    if(menuObj==null)
      Log.Error("Menu object is invalid");
    if(menuItems=="" || menuItems==null)
      Log.Error("Menu items is empty"); 
    if(!isMenuItemEnabled(param_menuObj, menuItems)){
      Log.Error("Menu item is disabled"); 
    }     
  }
}

//Use this function to verify whether a menu/submenu is enabled (can be clicked) or not
//Can be used on menu with multiple levels of submenus
//@menuObj: The toolbar object of type TdxBarControl class 
//@menuItems: The captions of the menu and submenus in string format. 
//            Use '|' separator to separate levels of submenu
//            E.g. clickMenuItem(menuObj, "Accounting|US Payroll|Payroll Items")
function isMenuItemEnabled(menuObj, menuItems)
{
  var arrstr, len, counter, counter2, found;
  if(menuObj!=null && menuItems!=null && menuItems!="")
  { 
    //split menuitems into array based on | as delimiter
    arrstr = menuItems.split("|");
    found = false; 
    for(counter=0;counter<arrstr.length;counter++)
    {
      for(counter2=0;counter2<menuObj.ItemLinks.Count;counter2++)
      //search for the menu/submenu
      if(removeAmpersand(menuObj.ItemLinks.Items(counter2).Caption)==arrstr[counter])
      {
        //pointing to the found menu object
        found = true; 
        menuObj = menuObj.ItemLinks.Items(counter2).Item;  
        result = (menuObj.GetEnabled()==true);
        return result;                                                                                                                                                                                 
      }
    }    
    if(!found)Log.Error("Menu item not found");   
    } 
}

//-----------------------------------------------------------//
//---------------------INTERNAL USAGE------------------------//
//-----------------------------------------------------------//

//This function is to remove the ampersand(&) sign, which is used to represent shortcut key in the caption
//And replace double ampersands with one
function removeAmpersand(str)
{
  str = str.replace("&&","*|##|*");
  str = str.replace("&","");
  str = str.replace("*|##|*","&");
  return str;
}


