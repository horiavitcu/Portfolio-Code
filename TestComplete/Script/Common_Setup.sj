//Function to initialise Project Suite parameters from commnad line call.
//All additional parameters passed from command line should comply with the following format: /<ParameterName>=<value>
function InitialiseProjectParameters()
{
  //Log all passed parameters from command line.
  Log.AppendFolder("Project Parameters Initialisation");
  var nArgs = BuiltIn.ParamCount();
  Log.Message("Total number of command-line arguments: " + nArgs);
  Log.Message("The fully-qualified name of the TestComplete executable: " + BuiltIn.ParamStr(0));

  for (var i = 1; i <= nArgs ; i++)
    Log.Message("Arg " + i + ": " + BuiltIn.ParamStr(i));
    
  if(nArgs > 4)
  {
    //Template code to read a parameter passed from commnad line.
    //The code assumes that the parameter is passed in the following format: /<ParameterName>=<value>
  
    //---Teplate code start---
    //Read the whole parameter name, assignment operator and value from passed argument.
    //For each passed parameter there should be a declared Project Suite temporary variable to hold the value and
    //a persistent variable to hold the parameter index in commnad line arguments.
    var executionModeParam = BuiltIn.ParamStr(ProjectSuite.Variables.ExecutionModeParamIndex);
    //Convert the variable to a string
    var executionModeParamStr = aqConvert.VarToStr(executionModeParam);

    //Hold the current list separator settings.  
    var tmpListSeparator = aqString.ListSeparator;
    //Set the list separator to "=" to make it possible to get the parameter value from the argument string
    aqString.ListSeparator = "=";
    //Get the parameter's value.
    var executionMode = aqString.GetListItem(executionModeParamStr, 1);
    //Reset the list separator settings to the initial value.
    aqString.ListSeparator = tmpListSeparator;  

    //Store the parameter value to the Project Suite variable.  
    ProjectSuite.Variables.ExecutionMode = executionMode;
    //---Template code end---
  }
    
  Log.PopLogFolder();
}

//Updates the ATCs parameters based on the initialisation parameters passed
//from commnad line. 
function UpdateProjectParameters()
{
  //Update the Tested Application execution path.
  UpdateTestedAppsExecutionPath();
  
  //The tests are executed on a clean installation environment.
  if(ProjectSuite.Variables.ExecutionMode == "BI")
  {
     ProjectSuite.Variables.UserCode = ProjectSuite.Variables.BI_Variables.Value("UserCode");
     ProjectSuite.Variables.UserPassword = ProjectSuite.Variables.BI_Variables.Value("UserPassword");
     ProjectSuite.Variables.ApplicationServerName = ProjectSuite.Variables.BI_Variables.Value("ApplicationServerName");
     ProjectSuite.Variables.DatabaseServerName = ProjectSuite.Variables.BI_Variables.Value("DatabaseServerName");
     ProjectSuite.Variables.CompanyCode = ProjectSuite.Variables.BI_Variables.Value("CompanyCode");
  }
  //The tests are executed on debug environment.
  else if(ProjectSuite.Variables.ExecutionMode == "BDT") 
  {
    ProjectSuite.Variables.UserCode = ProjectSuite.Variables.BDT_Variables.Value("UserCode");
    ProjectSuite.Variables.UserPassword = ProjectSuite.Variables.BDT_Variables.Value("UserPassword");
    ProjectSuite.Variables.ApplicationServerName = ProjectSuite.Variables.BDT_Variables.Value("ApplicationServerName");
    ProjectSuite.Variables.DatabaseServerName = ProjectSuite.Variables.BDT_Variables.Value("DatabaseServerName");
    ProjectSuite.Variables.CompanyCode = ProjectSuite.Variables.BDT_Variables.Value("CompanyCode");
  } 
}

//Updates the Tested applications path based on the ExecutionMode parameter 
//passed from commnad line.
function UpdateTestedAppsExecutionPath()
{
  for(var i = 0; i < TestedApps.Count; i++)
  {
    var testedApplication = TestedApps.Items(i);
    if(ProjectSuite.Variables.VariableExists(testedApplication.ItemName + "_" + ProjectSuite.Variables.ExecutionMode + "_Path"))
      testedApplication.Path = ProjectSuite.Variables.VariableByName(testedApplication.ItemName + "_" + ProjectSuite.Variables.ExecutionMode + "_Path");
  }
}