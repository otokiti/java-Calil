echo off

@rem JAVA_HOME
set JAVA_HOME=C:\プロジェクト\pleiades\java\11

@rem 実行及び、関連jarファイルのパス記入(*.jar のようにワイルドカードでの指定も可能です)
set JAR_PATH=./app/*.jar

@rem 出力先フォルダ
set OUT_DIR=jre

for /f usebackq %%A in (`%JAVA_HOME%\bin\jdeps --print-module-deps %JAR_PATH%`) do set MODULE=%%A

rem %JAVA_HOME%\bin\jlink --compress=2 --module-path %JAVA_HOME%\jmods --add-modules %MODULE% --output %OUT_DIR%
%JAVA_HOME%\bin\jlink --compress=2 --module-path %JAVA_HOME%\jmods --add-modules %MODULE%,jdk.crypto.ec --output %OUT_DIR%
rem エラーが発生したので「jdk.crypto.ec」を追加

pause
