//Waits for the specified object to disappear for the specified time interval.
//If the object does not get disposed in the specified amount of time the
//error message passed is logged
//@timeout: The time to wait for the object to get disposed.
//@object: The object to wait for
//@errorMessage: The message to log if the object does not get disposed in 
//              the specified amount of time.
function WaitForObjectToDispose (timeout, object, errorMessage)
{
  //Variable to hold the total time we are waiting
  var totalWaitTimeout = 0;
  //Until specified object disappears/gets disposed
  while(object.Exists == true)
  {
    //Delays the test execution for the specified time period.
    Delay(500);
    //Recalculate the total time we are waiting
    totalWaitTimeout = totalWaitTimeout + 500;
    
    if(totalWaitTimeout > timeout)
    {
      Log.Error(errorMessage, "");
      break;
    }
  }
}

//Waits for the specified object to appear for the specified time interval.
//If the object does not appear in the specified amount of time the
//error message passed is logged
//@timeout: The time to wait for the object to appear.
//@object: The object to wait for
//@errorMessage: The message to log if the object does not appear in 
//              the specified amount of time.
function WaitForObjectToAppear (timeout, object, errorMessage)
{
  //Variable to hold the total time we are waiting
  var totalWaitTimeout = 0;
  //Until specified object exists
  while(object.Exists != true)
  {
    //Delays the test execution for the specified time period.
    Delay(500);
    //Recalculate the total time we are waiting
    totalWaitTimeout = totalWaitTimeout + 500 + Options.Run.Timeout;
    
    if(totalWaitTimeout > timeout)
    {
      Log.Error(errorMessage, "");
      break;
    }
  } 
}

//Validate Current window with the caption
function ValidateWindow (timeout, object, caption, errorMessage)
{
  //Call Wait for object 
  WaitForObjectToAppear(timeout, object, errorMessage);

  //Check if object is present
  if(object.caption == caption)
  {
   Log.Message(caption + " Window is present ");
  }
  else
  {
   Log.Error(caption + " Window is not present ");
  }
}

//Validate Current window is Visible
function ValidateWindowVisible (timeout, object, caption, errorMessage)
{
  //Call Wait for object 
  WaitForObjectToAppear(timeout, object, errorMessage);

  //Check if object is present
  if(object.Visible == true)
  {
   Log.Message(object + " Window is Visible ");
  }
  else
  {
   Log.Error(object + " Window is not Visible ");
  }
}
