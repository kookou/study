set username=taepd
set tempFolder=C:\Users\taepd\OneDrive\���� ȭ��\�ӽ������
set saveFolder=C:\Users\taepd\OneDrive\���� ȭ��\����ȭ�� ������

mkdir "%tempFolder%"

copy "C:\Users\%username%\AppData\Local\Packages\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\LocalState\Assets" "%tempFolder%"

forfiles /p "%tempFolder%" /C "cmd /c if @fsize LEQ 200000 del @path"

ren "%tempFolder%\*.*" *.jpg

move /y "%tempFolder%\*.*" "%saveFolder%"

rd "%tempFolder%"

%SystemRoot%\explorer.exe "%saveFolder%"
