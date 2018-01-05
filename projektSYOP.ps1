Function Get-FileName($initialDirectory)
{
    [System.Reflection.Assembly]::LoadWithPartialName("System.windows.forms") | Out-Null
    
    $OpenFileDialog = New-Object System.Windows.Forms.OpenFileDialog
    $OpenFileDialog.initialDirectory = $initialDirectory
    #$OpenFileDialog.filter = "CSV (*.csv)| *.csv"
    $OpenFileDialog.ShowDialog() | Out-Null
    $OpenFileDialog.filename
}



$global:inputfile="empty"
$global:inputfile2="empty2"

Function getDataFromExcel($path)
{
  
 $startRow=1
 $startCol=1
 
 $endRow=9
 $endCol=3
  
$excel=new-object -com excel.application
$wb=$excel.workbooks.open($path)

 
     $sh=$wb.Sheets.Item(1)
  
 

  for($i=$startRow ; $i-le $endRow ; $i++){
    for($j=$startCol ; $j-le $endCol ; $j++){ 
           
   $kom=$sh.Cells.Item($i,$j).Text
    write-host $kom

    }
    }
 
 
$excel.Workbooks.Close()
Stop-Process -processname  Excel

}



   function ConnectMySQL([string]$user,[string]$pass,[string]$MySQLHost,[string]$database) {
 
# Load MySQL .NET Connector Objects
[void][system.reflection.Assembly]::LoadWithPartialName("MySql.Data")
 
# Open Connection
$connStr = "server=" + $MySQLHost + ";port=3306;uid=" + $user + ";pwd=" + $pass + ";database="+$database+";Pooling=FALSE"
$conn = New-Object MySql.Data.MySqlClient.MySqlConnection($connStr)
$conn.Open()
$cmd = New-Object MySql.Data.MySqlClient.MySqlCommand("USE $database", $conn)
return $conn
 
}
 
function WriteMySQLQuery($conn, [string]$query) {
 
$command = $conn.CreateCommand()
$command.CommandText = $query
$RowsInserted = $command.ExecuteNonQuery()
$command.Dispose()
if ($RowsInserted) {
return $RowInserted
} else {
return $false
}
}

 
 $Global:excel="" 
 $Global:wb="" 
 $Global:sh="" 
 


 #tworzymy instancję okna
$form = New-Object System.Windows.Forms.Form
#okno otrzymuje nazwę, rozmiar oraz pozycję (środek ekranu)
#podobne właściwości otrzymują pozostałe obiekty wrzucane na okno
$licznik=0
$form.Text = "PowerShell GUI Test"
$form.Size = New-Object System.Drawing.Size(500,520)
$form.StartPosition = "CenterScreen"


$button1 = New-Object System.Windows.Forms.Button
$button1.Text="Wybierz plik do zapisu"
$button1.Size = New-Object System.Drawing.Size(100,50)
$button1.Location = New-Object System.Drawing.Size(100,100)
$form.Controls.Add($button1)

$button2 = New-Object System.Windows.Forms.Button
$button2.Text="Wyświetl dane"
$button2.Size = New-Object System.Drawing.Size(100,50)
$button2.Location = New-Object System.Drawing.Size(250,100)
$form.Controls.Add($button2)

$button3 = New-Object System.Windows.Forms.Button
$button3.Text="Baza"
$button3.Size = New-Object System.Drawing.Size(100,50)
$button3.Location = New-Object System.Drawing.Size(250,300)
$form.Controls.Add($button3)

$Label1 = New-Object System.Windows.Forms.Label
$Label1.Text =  $global:inputfile
$Label1.AutoSize = $True
$Label1.Location = New-Object System.Drawing.Size(150,200)
$Form.Controls.Add($Label1)

[System.Collections.Arraylist] $Global:arrayList=@()


Function loadXmlFile(){
   
 
 
 [xml]$TablesAttribute = Get-Content   C:\temp\info.xml

 $war1 = $TablesAttribute.Tables.Table 
 $war1.ChildNodes.count
 
 for($i=0;$i -le $war1.ChildNodes.Count;$i++){
    $arrayList.Add(  $war1.ChildNodes.Item($i))
       }
 
 $ilosc = $war1.ChildNodes.count 
  
 Clear-Content "c:\temp\test.txt" 
 
    $arrayList >> "c:\temp\test.txt" 
 
 Write-host "Ilosc: "$ilosc
 $a=(Get-Content "c:\temp\test.txt") | Select-Object -last  $ilosc

 Write-host "zamienna a: " $a[0]
                        
  Write-Host "test przycisk od xml"                            

}

loadXmlFile 


Function insertData(){

    
                         $query = 'INSERT INTO page (filename,date,time) VALUES ("$filename","$date","$time")'
 
                       Write-Host $Global:arrayList[5]
 

 
                        # setup vars
                        $user = 'root'
                        $pass = ''
                        $database = 'syop'
                        $MySQLHost = '127.0.0.1'
 
                        # Connect to MySQL Database
                        $conn = ConnectMySQL $user $pass $MySQLHost $database
                        # Read all the records from table


                        $query = 'INSERT INTO data (name ) VALUES ("'+  $a[0]  +'")'
                       
                        # $query = "CREATE TABLE `syop`.`zbiorqwe` ( `qwe` TEXT NULL , `wer` TEXT NULL , `ert` TEXT NULL ) ENGINE = InnoDB;"
                      


                       $query = 'INSERT INTO data (name ) VALUES ("akal")'
                        $Rows = WriteMySQLQuery $conn $query
                        Write-Host "Executed: " $query

}


Function getCellFromExcel($w, $k)
{ 



#$excel=new-object -com excel.application
#$wb=$excel.workbooks.open("C:\temp\dane.xls")
#$sh=$wb.Sheets.Item(1)


    $kom=$Global:sh.Cells.Item($w,$k).Text
   
 
#$excel.Workbooks.Close()
#Stop-Process -processname  Excel

return $kom

}


Function insertExcelData(){
                          # setup vars
                        $user = 'root'
                        $pass = ''
                        $database = 'syop'
                        $MySQLHost = '127.0.0.1'
 
                        # Connect to MySQL Database
                        $conn = ConnectMySQL $user $pass $MySQLHost $database
                        # Read all the records from table
$numberOfColumns=$a.Count-5


 for($k=0; $k -lt $a[3]-$a[1] +1 ; $k++){



$kumulNames=""
$kumulValues=""
 for($i=0; $i -lt $numberOfColumns  ; $i++){

if($i -eq $numberOfColumns-1){
$kumulNames+=$a[5+$i] + "  "
}
else{
$kumulNames+=$a[5+$i] + " , "
}

 }
 
 for($j=0; $j -lt $numberOfColumns  ; $j++){
 
$row=0
 $row=$k+$a[1] 
 #Write-Host "row:>" $row "<"

 
 $col=0
# $col=$j+1
$col=$j+$a[2]

 if($j -eq $numberOfColumns-1){
$kumulValues+= " "" "+(getCellFromExcel $row $col)+" "" "
}
else{
$kumulValues+= " "" "+(getCellFromExcel $row $col)+" "" , "
}

 }

 


 


$insertQuery ="INSERT INTO "  +$a[0] + " ( "+$kumulNames+" ) VALUES "+ " ( " +$kumulValues+ " ) "

 
  #Write-Host "Test Query: " $insertQuery 


                         $Rows = WriteMySQLQuery $conn $insertQuery
                         Write-Host "Executed: " $insertQuery

}
$Global:excel.Workbooks.Close()
Stop-Process -processname  Excel

}




Function createTable(){




#$tableName=$a[0]
$tableName="dd"#################################################bedzie trzeba zmienic#######################
        

 $query="CREATE TABLE ``syop``."+$tableName
 
$kumul=""
        for($i=5 ; $i -lt $a.Count; $i++){

            if($i-eq $a.count-1){

                $kumul+=$a[$i] +"TEXT NULL  "}

            else {
                $kumul+=$a[$i] +"TEXT NULL , "
            }


            }


$query=$query+"("+ $kumul+")"

 

   # Write-host "Query:"  $query 
    # zapytanie tworzace tebelę
   # return $query    

                        # setup vars
                        $user = 'root'
                        $pass = ''
                        $database = 'syop'
                        $MySQLHost = '127.0.0.1'
 
                        # Connect to MySQL Database
                        $conn = ConnectMySQL $user $pass $MySQLHost $database
                        # Read all the records from table
                       
                       
                     $query   
                      


                        #$query = 'INSERT INTO data (name ) VALUES ("akal")'
                        $Rows = WriteMySQLQuery $conn $query 
                        Write-Host "Executed: " $query

}



Function createTableStatement(){


$tableName=$a[0]

 $query="CREATE TABLE ``syop``."+$tableName


 $tableName=$a[0]
$kumul=""
        for($i=5 ; $i -lt $a.Count; $i++){

            if($i-eq $a.count-1){

                $kumul+=$a[$i] +"TEXT NULL  "}

            else {
                $kumul+=$a[$i] +"TEXT NULL , "
            }


            }


$query=$query+"("+ $kumul+")"

 

   # Write-host "Query:"  $query 
    # zapytanie tworzace tebelę
    return $query    

}


 


 # CREATE TABLE `syop`.`zbior` ( `qwe` TEXT NULL , `wer` TEXT NULL , `ert` TEXT NULL ) ENGINE = InnoDB;

 






                        $button1.add_Click(
                        {
                          $global:inputfile = Get-FileName "c:/"
                          Write-Host "Excel: "$inputfile
                          $Label1.Text =   $inputfile



                         $Global:excel=new-object -com excel.application
                        $Global:wb=$Global:excel.workbooks.open($inputfile)
                        $Global:sh=$Global:wb.Sheets.Item(1)
    
                        })

 

                        $button2.add_Click({
                          getDataFromExcel $inputfile
                        })

  $button3.add_Click({
#TO musi byś zawsze
# createTable 
   insertExcelData
    #  insertData                     
                        })


    













$form.ShowDialog();
######################################################################################################