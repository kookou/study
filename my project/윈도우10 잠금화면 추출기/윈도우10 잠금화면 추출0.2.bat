set ������=taepd
set �����������=C:\Users\taepd\OneDrive\���� ȭ��\�ӽ������

copy "C:\Users\%������%\AppData\Local\Packages\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\LocalState\Assets" "%�����������%"

forfiles /p "%�����������%" /C "cmd /c if @fsize LEQ 200000 del @path"

ren "%�����������%\*.*" *.jpg

%SystemRoot%\explorer.exe "%�����������%"
