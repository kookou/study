set username=taepd
set folder=C:\Users\taepd\OneDrive\���� ȭ��\�ӽ������

copy "C:\Users\%username%\AppData\Local\Packages\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\LocalState\Assets" "%folder%"

forfiles /p "%folder%" /C "cmd /c if @fsize LEQ 200000 del @path"

ren "%folder%\*.*" *.jpg

%SystemRoot%\explorer.exe "%folder%"
