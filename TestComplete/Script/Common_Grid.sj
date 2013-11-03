//-----------------------------------------------------------//
//---------------------REGULAR FUNCTIONS---------------------//
//-----------------------------------------------------------//

//Function that can be used for clicking on a grid's cell.
//@grid: The grid to click on
//@cellValue: The cell value to search for in the grid. If the value is found the
//            parent cell will be clicked.
//@columnId: The header caption of the column to serach for the cell value in.
//           This can be either the index of the column or the caption. It is advised to use the 
//           caption of the column
//           This parameter is optional. If it is not specified the whole grid will be 
//           searched. The first cell found will be clicked.
function clickOnCell(grid, cellValue, columnId)
{
  var column = null;
  
  //Log an error if the specified grid is noit of expected type.
  //Log an error if the specified gird does not have 1 View 
  if(isClassValid(grid)&&isViewUnique(grid));
    
  //get the grid's main view.
  var gridMainView = grid.ActiveView;
  
  //If the columnId is specified, search in only one   
  if(columnId != null)
  {
    //Get the column by the specified Id.
    column = getColumn(gridMainView, columnId);  
    //Log an error if the column is not found.
    if(column == null)
      Log.Error("Could not find column with Id: " + columnId);
      
    grid.ClickCell(indexOfRecord(cellValue, gridMainView, column), column.Index);
    return;  

  }
  //Search in all grid cell values.
  else
  {                                    
      for(var colIndex = 0; colIndex < gridMainView.VisibleColumnCount; colIndex++)
      {
        column = gridMainView.VisibleColumns(colIndex);
        if(indexOfRecord(cellValue, gridMainView, column)!=-1)
        {
          grid.ClickCell(indexOfRecord(cellValue, gridMainView, column), column.Index);
          return; 
        }
      }
    
  }
  
  Log.Error("Could not find the cell to click on based on the specified data.");
}

//Function that can be used for double clicking on a grid's cell.
//@grid: The grid to click on
//@cellValue: The cell value to search for in the grid. If the value is found the
//            parent cell will be clicked.
//@columnId: The header caption of the column to serach for the cell value in.
//           This can be either the index of the column or the caption. It is advised to use the 
//           caption of the column
//           This parameter is optional. If it is not specified the whole grid will be 
//           searched. The first cell found will be clicked.
function doubleClickOnCell(grid, cellValue, columnId)
{
  var column = null;
  
  //Log an error if the specified grid is noit of expected type.
  //Log an error if the specified gird does not have 1 View 
  if(isClassValid(grid)&&isViewUnique(grid));
   
  //get the grid's main view.
  var gridMainView = grid.ActiveView;
  
  //If the columnId is specified, search in only one   
  if(columnId != null)
  {
    //Get the column by the specified Id.
    column = getColumn(gridMainView, columnId);  
    //Log an error if the column is not found.
    if(column == null)
      Log.Error("Could not find column with Id: " + columnId);
      
    grid.DblClickCell(indexOfRecord(cellValue, gridMainView, column), column.Index, 0);
    return;  
    
  }
  //Search in all grid cell values.
  else
  {                                    
      for(var colIndex = 0; colIndex < gridMainView.VisibleColumnCount; colIndex++)
      {
        column = gridMainView.VisibleColumns(colIndex);
        if(indexOfRecord(cellValue, gridMainView, column)!=-1)
        {
          grid.DblClickCell(indexOfRecord(cellValue, gridMainView, column), column.Index, 0);
          return; 
        }
      }    
  }
  
  Log.Error("Could not find the cell to click on based on the specified data.");
}


//Function that can be used for right-clicking on a grid's cell.
//@grid: The grid to right-click on
//@cellValue: The cell value to search for in the grid. If the value is found the
//            parent cell will be right-clicked.
//@columnId: The header caption of the column to search for the cell value in.
//           This can be either the index of the column or the caption. It is advised to use the 
//           caption of the column
//           This parameter is optional. If it is not specified the whole grid will be 
//           searched. The first cell found will be right-clicked.
function clickROnCell(grid, cellValue, columnId)
{
  var column = null;
  
  //Log an error if the specified grid is not of expected type.
  //Log an error if the specified grid does not have 1 View 
  if(isClassValid(grid)&&isViewUnique(grid));
    
  //get the grid's main view.
  var gridMainView = grid.ActiveView;
  
  //If the columnId is specified, search in only one   
  if(columnId != null)
  {
    //Get the column by the specified Id.
    column = getColumn(gridMainView, columnId);  
    //Log an error if the column is not found.
    if(column == null)
      Log.Error("Could not find column with Id: " + columnId);
      
    grid.ClickCellR(indexOfRecord(cellValue, gridMainView, column), column.Index);
    return;  

  }
  //Search in all grid cell values.
  else
  {                                    
      for(var colIndex = 0; colIndex < gridMainView.VisibleColumnCount; colIndex++)
      {
        column = gridMainView.VisibleColumns(colIndex);
        if(indexOfRecord(cellValue, gridMainView, column)!=-1)
        {
          grid.ClickCellR(indexOfRecord(cellValue, gridMainView, column), column.Index);
          return; 
        }
      }
    
  }
  
  Log.Error("Could not find the cell to right-click on based on the specified data.");
}

//Function that can be used for veryfying if the specified grid contains a cell value.
//It returns true if the value is found in the grid, false otherwise
//@grid: The grid to search the cell value in.
//@cellValue: The cell value to search for in the grid.
//@columnId: The header caption of the column to serach for the cell value in.
//           This can be either the index of the column or the caption. It is advised to use the 
//           caption of the column.
//           This parameter is optional. If it is not specified the whole grid will be 
//           searched. If the specified value is found under any column, it will return true;
function gridContainsValue(grid, cellValue, columnId)
{
  var column = null;
  
  //Log an error if the specified grid is noit of expected type.
  //Log an error if the specified gird does not have 1 View 
  if(isClassValid(grid)&&isViewUnique(grid));
   
  //get the grid's main view.
  var gridMainView = grid.ActiveView;
  
  //If the columnId is specified, search in only one   
  if(columnId != null)
  {
    //Get the column by the specified Id.
    column = getColumn(gridMainView, columnId);  
    //Log an error if the column is not found.
    if(column == null)
      Log.Error("Could not find column with Id: " + columnId);
    //Returns true if it finds the value    
    if(indexOfRecord(cellValue, gridMainView, column)!=-1)return true;  

  }
  //Search in all grid cell values.
  else
  {
     for(var colIndex = 0; colIndex < gridMainView.VisibleColumnCount; colIndex++)
      {
        column = gridMainView.VisibleColumns(colIndex);
        if(indexOfRecord(cellValue, gridMainView, column)!=-1)return true;
      }
  }
  return false; 
}

//Use this function to retrieve the contents of a specific cell, specified by row and
//column index. The distext is different from cell value due to the fact that raw database
//data are oftnely formated beofore rendered on the screen. Examples of sucg data is dates,
//currencies etc...
//@grid: The grid to get cell contents fro
//@rowIndex: The rowIndex of the cell
//@columnId: The header caption of the column to get the cell value for.
//           This can be either the index of the column or the caption. It is advised to use the 
//           caption of the column.
function getCellContents(grid, rowIndex, columnId)
{
  //Log an error if the specified grid is noit of expected type.
  //Log an error if the specified gird does not have 1 View 
  if(isClassValid(grid)&&isViewUnique(grid));
 
  //get the grid's main view.
  var gridMainView = grid.ActiveView;
  
  //Get the column by the specified Id.
  column = getColumn(gridMainView, columnId);  
  //Log an error if the column is not found.
  if(column == null)
    Log.Error("Could not find column with Id: " + columnId);
   
  Log.Message("Read cell value: " + gridMainView.ViewData.Rows(rowIndex).Values(column.Index));   
  return gridMainView.ViewData.Rows(rowIndex).Values(column.Index);
}

//Use this function to retrieve the display text of a specific cell, specified by row and
//column index. The distext is different from cell value due to the fact that raw database
//data are oftnely formated beofore rendered on the screen. Examples of sucg data is dates,
//currencies etc...
//@grid: The grid to get cell contents fro
//@rowIndex: The rowIndex of the cell
//@columnId: The header caption of the column to get the cell value for.
//           This can be either the index of the column or the caption. It is advised to use the 
//           caption of the column.
function getCellDisplayText(grid, rowIndex, columnId)
{
   
  //Log an error if the specified grid is noit of expected type.
  //Log an error if the specified gird does not have 1 View 
  if(isClassValid(grid)&&isViewUnique(grid));
   
  //get the grid's main view.
  var gridMainView = grid.ActiveView;
  
  //Get the column by the specified Id.
  column = getColumn(gridMainView, columnId);  
  //Log an error if the column is not found.
  if(column == null)
    Log.Error("Could not find column with Id: " + columnId);
   
  Log.Message("Read cell value: " + gridMainView.ViewData.Rows(rowIndex).DisplayTexts(column.Index));   
  return gridMainView.ViewData.Rows(rowIndex).DisplayTexts(column.Index);
}

//Function that returns true if row is selected and false otherwise
//@grid: The grid to click on
//@cellValue: The cell value to search for in the grid.
//@columnId: The header caption of the column to serach for the cell value in.
//           This can be either the index of the column or the caption. It is advised to use the 
//           caption of the column 
function isRowSelected(grid, cellValue, columnId) 
{
  //Log an error if the specified grid is noit of expected type.
  //Log an error if the specified gird does not have 1 View 
  if(isClassValid(grid)&&isViewUnique(grid));
   
  //get the grid's main view.
  var gridMainView = grid.ActiveView;
  
  //Check if this is a group by column
  var column = getGroupColumn(gridMainView, columnId);
  //If not try to get a regular column reference
  if(column == null)
    column = getColumn(gridMainView, columnId);
  
    //If no cilumn can be retrieved, log an error  
  if(column == null)
    Log.Error("Could not find column with id: " + columnId);
  
  var rowIndex = indexOfRecord(cellValue, gridMainView, column);
  if (rowIndex > -1) {
      var row = gridMainView.ViewData.Rows(rowIndex);
      return row.Selected; 
  }
  return false;
}

//-----------------------------------------------------------//
//---------CELL FUNCTIONS BASED ON INDEX CELL----------------//
//-----------------------------------------------------------//


//Function that can be used for clicking Index based grid's cell.
//@grid: The grid to click on
//@idxColumnId: The header caption of the column index to serach for the cell value in.
//@idxcellValue: The Index of the cell value to search for in the grid.  
//@columnId: The header caption of the column to serach for the cell value in.
//@isSingleClick , set this true if you want single click, else false for double click
function clickOnCellBasedOnIdx(grid, idxColumnId , idxCellValue, columnId,isSingleClick)
{
  var column = null;
  
  //Log an error if the specified grid is noit of expected type.
  //Log an error if the specified gird does not have 1 View 
  //Error loggin is done in respective function 
  if(isClassValid(grid)&&isViewUnique(grid));
    
  //get the grid's main view.
  var gridMainView = grid.ActiveView;
  
  //If the columnId is specified, search in only one   
  if(columnId != null)
  {
    //Get the column by the specified Id.
    column = getColumn(gridMainView, columnId);  
    //Log an error if the column is not found.
    if(column == null)
      Log.Error("Could not find column with Id: " + columnId);
    if(isSingleClick)
      grid.ClickCell(indexOfRecord(idxCellValue, gridMainView, idxColumnId), column.Index );
    else 
      grid.DblClickCell(indexOfRecord(idxCellValue, gridMainView, idxColumnId), column.Index );        
  } 
  else 
  {
    Log.Error("Column to click is empty");
  }
}

//Use this function to set a cell value.
//@grid: The grid to set a cell value on
//@indexColumnId: The index column used to locate the specific row to be edited
//@indexCellValue: The cell value used to locate the edited row index in the gird for
//                 the specified indexColumnId
//@columnId: The column for which we need to set the value on
//@value: The new value to set
function setCellValue(grid, indexColumnId, indexCellValue, columnId, value)
{       
   //Get the index Column
  var editedColumn = getColumn(grid.ActiveView, columnId);
  //Localte the row we ned to edit based on the index column and index cell value 
  var editedRowIndex = indexOfRecord(indexCellValue, grid.ActiveView, indexColumnId);

  //Set focus on the row we need to edit
  grid.ActiveView.DataController.FocusedRowIndex = editedRowIndex;
  
  //Set the value of the cell to the specified value.
  grid.ActiveView.DataController.SetEditValue(editedColumn.Index, value, 1);
}

//This function is to retrieve the cell value of a specified column by using another cell value, 
//which has a unique identifier in the grid as an index search.
//@grid: The grid from which the cell value is retrieved
//@indexValue: The cell value
//@indexColumn: The column caption of the index value
//@dataColumn: the column caption of the cell value to be retrieved based on the index search
function getCellContentByIndexCell(grid, indexValue, indexColumn, dataColumn)
{
  var column1 = null;
  var column2 = null;
  
  //Log an error if the specified grid is not of expected type.
  //Log an error if the specified gird does not have 1 View 
  if(isClassValid(grid)&&isViewUnique(grid));
    
  //get the grid's main view.
  var gridMainView = grid.ActiveView;
  
  //Search for the value only if the indexColumn and dataColumn are not null   
  if(indexColumn != null && dataColumn != null)
  {
    //Get the column by the specified Id.
    column1 = getColumn(gridMainView, indexColumn);
    column2 = getColumn(gridMainView, dataColumn);   
    //Log an error if the column is not found.
    if(column1 == null)
      Log.Error("Could not find column with Id: " + indexColumn);
    if(column2 == null)
      Log.Error("Could not find column with Id: " + dataColumn); 
    return getCellContents(grid, indexOfRecord(indexValue, gridMainView, column1),column2.Index);
  }
  else
	Log.Error("Column(s) specified are invalid");
}


//This function is validate the cell value in the grid identified by the index search of another cell value
//@grid: The grid from which the cell value is retrieved
//@indexValue: The cell value
//@indexColumn: The column caption of the index value
//@dataColumn: The column caption of the cell value to be retrieved based on the index search
//@expectedValue: The expected value to be retrieved
function validateCellValueByIndexCell(grid, indexValue, indexColumn, dataColumn, expectedValue)
{
  var actualValue;
  actualValue = getCellContentByIndexCell(grid, indexValue, indexColumn, dataColumn);
  if(actualValue != expectedValue)
    Log.Error("Value "+expectedValue+" does not equal to "+actualValue) 
}

//This function use for click check box of Grid.
//@Grid : Grid a object use for click
//@specifiedCellValue : Thougth this variable to get which row need select or not select.
//@specifiedColumn : Use for search which row has specifiedCellValue
//@selectColumn : Use for which column need click
//@select : A boolean variable, if true select the check box, flase not select.
function clickCheckBoxOfGrid(Grid, specifiedCellValue, specifiedColumn, selectColumn, select)
{
    var View = Grid.ActiveView;
    //clickRowIndex use for which row need select/not select.
    var cilckRowIndex = 0;
    //the rowIndex of specifiedCellValue in specifiedColumn that use for get the select column checked status.
    //In Generate PO gird if have two vendors that rowIndex will be not equals clickRowIndex
    //So need define these two variable.
    var rowIndex = 0;
    var isSelected = "F";
    for(; rowIndex < View.ViewData.RowCount; rowIndex++)
    {                                  
      var cellValue = getCellContents(Grid, rowIndex, specifiedColumn);
      if(cellValue==specifiedCellValue) {
          //get the specified row the select status.
          isSelected = getCellContents(Grid, rowIndex, selectColumn);
          break;
      }
    }   
    //Get the column by the specified Id.
    column = getColumn(View, specifiedColumn); 
 
    //Log an error if the column is not found.
    if(column == null)
        Log.Error("Could not find column with Id: " + specifiedColumn);
    clickRowIndex = indexOfRecord(specifiedCellValue, View, column);
    
    //Get the column by the specified Id.
    column = getColumn(View, selectColumn);
    if(column == null)
        Log.Error("Could not find column with Id: " + selectColumn);
        
    //if select is true select the specified column 
    if(select)
    {
        //"F" is current checkbox is not selected, "T" is selected.
        if((isSelected=="F") || (isSelected=="False"))  {
            Grid.ClickCell(clickRowIndex, column.Index);
        }
    }
    else
    {
       if((isSelected=="T") || (isSelected == "True"))
       {
           Grid.ClickCell(clickRowIndex, column.Index);  
       }
    }      
}

//This function use for validate the check box of grid is checked.
//@Grid : Grid a object use for verify.
//@specifiedCellValue : Thougth this variable to get which row need be verify is selected.
//@specifiedColumn : Use for search which row has specifiedCellValue.
//@selectColumn : Use for verify the select column checkbox is checked.
function validateCheckBoxOfGridIsChecked(Grid, specifiedCellValue, specifiedColumn, selectColumn)
{
    //Get the active view of grid
    var View = Grid.ActiveView;
    var isSelected = "F";
    //Search the specified row check box is select status.
    for(var rowIndex = 0; rowIndex < View.ViewData.RowCount; rowIndex++)
    {                                  
      var cellValue = getCellContents(Grid, rowIndex, specifiedColumn);
      if(cellValue==specifiedCellValue) {
          //get the specified row the select status.
          isSelected = getCellContents(Grid, rowIndex, selectColumn);
          break;
      }
    }  

    //"F" is current checkbox is not selected, "T" is selected.
    if((isSelected=="F") || (isSelected=="False"))  {
        Log.Error("Check box for :" + specifiedCellValue +"window is not checked");
    }
    if((isSelected=="T") || (isSelected == "True")) {
        Log.Message("Check box for" + specifiedCellValue +" window is checked");  
    }
}


//-----------------------------------------------------------//
//---------------------GROUP FUNCTIONS-----------------------//
//-----------------------------------------------------------//

//Function that can be used to Expands a grouped Row
//@grid: The grid to get cell contents from
//@groupedColumnCaption: The caption of the specified grouped row
//@rowValue: The value of the specified grouped row 
function expandGroupRow(grid, groupedColumnCaption, rowValue)
{   
    //Set value for the groupedColumn Object 
    var groupedColumn = getGroupColumn(grid.ActiveView, groupedColumnCaption);
    
    if(groupedColumn == null)
      Log.Error("Could not find Grouped Column with caption: " + groupedColumnCaption);
    
    //Set value for the row  
    var rowIndex = indexOfRow(rowValue, grid.ActiveView, groupedColumn);
    
    if(rowIndex == -1)
      Log.Error("Could not find row for the specified index column and incex cell value.");
          
    //Expand the specified rowIndex 
    grid.ActiveView.ViewData.Rows(rowIndex).Expand(true);   		
}

//Function that can be used to Collapse a grouped Row
//@grid: The grid to get cell contents from
//@groupedColumnCaption: The caption of the specified grouped row
//@rowValue: The value of the specified grouped row
function colapseGroupRow(grid, groupedColumnCaption, rowValue)
{   
    //Sets value for the groupedColumn Object   
    var groupedColumn = getGroupColumn(grid.ActiveView, groupedColumnCaption);
    
    if(groupedColumn == null)
      Log.Error("Could not find Grouped Column with caption: " + groupedColumnCaption);
    
    //Sets value for the row  
    var rowIndex = indexOfRow(rowValue, grid.ActiveView, groupedColumn);
    
    if(rowIndex == -1)
      Log.Error("Could not find row for the specified index column and incex cell value.");
    
    //Collapses the specified rowIndex 
    grid.ActiveView.ViewData.Rows(rowIndex).Collapse(true);   		
}

//Function that can be used to select a grouped Row
//@grid: The grid to get cell contents from
//@groupedColumnCaption: The caption of the specified grouped row
//@rowValue: The value of the specified grouped row 
function selectGroupRow(grid, groupedColumnCaption, rowValue)
{
    //Sets value for the groupedColumn Object
    var groupedColumn = getGroupColumn(grid.ActiveView, groupedColumnCaption);
    
    if(groupedColumn == null)
      Log.Error("Could not find Grouped Column with caption: " + groupedColumnCaption);
    
    //Sets value for the row
    var rowIndex = indexOfRecord(rowValue, grid.ActiveView, groupedColumn);
    
    if(rowIndex == -1)
      Log.Error("Could not find row for the specified index column and incex cell value.");
    
    //Sets the specified rowIndex selected 
    grid.ActiveView.ViewData.Rows(rowIndex).SetSelected(true);
    grid.ActiveView.ViewData.Rows(rowIndex).SetFocused(true);
}

//Function that can be used for Clear All Selected Grouped Rows
//@grid: The grid to get cell contents from
function clearSelectedRows(grid){         
  for (var rowIndex = 0; rowIndex < grid.ActiveView.ViewData.RowCount; rowIndex++)
  { 
    //Clears all Selected Grouped Rows
    grid.ActiveView.ViewData.Rows(rowIndex).SetSelected(false); 
  }       
}

//Function that can be used for checking if a Grouped Row has Child Rows.
//Returns true/false if the row has or not Child Rows. 
//@grid: The grid to check for.
//@groupedRowValue: The Gouped Row value to search for in the grid.
function hasChildRows(grid, groupedRowValue)
{
   var gridActiveView = grid.ActiveView;   
   var numOfRows = gridActiveView.ViewData.RowCount;  //Number of rows of the specified grid.
   var hasChild = false;                                                                     
                
   for (var row = 0; row < numOfRows; row++)  //Iterate in all Grid Rows
   {
      //Check if the row has Parent row && if the parent row has the specified name (groupedRowValue)
      if ((gridActiveView.ViewData.Rows(row).ParentRecord != null) && 
          (gridActiveView.ViewData.Rows(row).ParentRecord.DisplayTexts(0) == groupedRowValue))
      {
        hasChild = true;                //Set the booleans value to true
        break;             
      }             
   }
       
   return hasChild;
}

//-----------------------------------------------------------//
//---------------------INTERNAL USAGE------------------------//
//-----------------------------------------------------------//

//Returns a column object specified by caption or index
//Used for internal purposes.
function getColumn(view, columnId)
{
  if (aqObject.GetVarType(columnId) == varOleStr)
  {
    for(var colIndex = 0; colIndex < view.VisibleColumnCount; colIndex++)
    {
      var column = view.VisibleColumns(colIndex);
      if (column.Caption == columnId)
          return column;  // The column is found
    }
    return null;     // The column is not found 
  }
  else
  {
    // The column is specified by index
      return view.Columns(columnId);
  }  
}

//Function that Returns a groupedColumn object specified by caption or index
//Used for internal purposes.
function getGroupColumn(view, groupColumnId){
  if (aqObject.GetVarType(groupColumnId) == varOleStr)
  {
    for(var groupedColIndex = 0; groupedColIndex < view.GroupedColumnCount; groupedColIndex++)
    {
      var column = view.GroupedColumns(groupedColIndex);
      if (column.Caption == groupColumnId)
          return column;  // The groupedcolumn is found
    }
    return null;     // The groupedcolumn is not found 
  }
  else
  {
      // The groupedcolumn is specified by index
      return view.GroupedColumns(groupColumnId);
  }  
}

function VerifyGridColumn(grid, columnId)
{
 var column = getColumn(grid.ActiveView, columnId);
 if (column == null)
 {
  Log.Picture(grid ,"Verify table grid with field"+columnId,"");
  Log.Error(columnId + " is not present in the grid");
 }
 else
 {
  Log.Message(columnId + " is present in the grid");
 }
}

function isClassValid(grid){
  //Log an error if the specified grid is noit of expected type.
  if(grid.ClassName != "TcxGrid" && grid.ClassName != "TICXGrid")
  {
    Log.Error("Accessed grid needs to be of TcxGrid class.");
    return false;
  }
  return true;
}

function isViewUnique(grid){
  //Log an error if the specified gird does not have 1 View  
  if(grid.viewCount != 1)
  {
    Log.Error("More than 1 views detected on grid.");
    return false;
  }
  return true;
}

//First occurrence (row index) of cellValue in the specified column
function indexOfRecord(cellValue, gridMainView, column){
  for(var rowIndex = 0; rowIndex < gridMainView.ViewData.RowCount; rowIndex++)
    {                                  
      var row = gridMainView.ViewData.Rows(rowIndex);
      if(aqString.Compare(aqString.Trim(cellValue), 
                          aqString.Trim(aqConvert.VarToStr(row.Values(column.Index))), 
                          true) == 0)
      {
        //grid.ClickCell(row.Index, column.Index);                
        return row.RecordIndex;                                                                  
      }
    }
    return -1;
}

//First occurrence (row index) of cellValue in the specified column
function indexOfRow(cellValue, gridMainView, column){
  for(var rowIndex = 0; rowIndex < gridMainView.ViewData.RowCount; rowIndex++)
    {                                  
      var row = gridMainView.ViewData.Rows(rowIndex);
      if(aqString.Compare(aqString.Trim(cellValue), 
                          aqString.Trim(aqConvert.VarToStr(row.Values(column.Index))), 
                          true) == 0)
      {
        //grid.ClickCell(row.Index, column.Index);                
        return row.Index;                                                                  
      }
    }
    return -1;
}