echo off

@rem JAVA_HOME
set JAVA_HOME=C:\�v���W�F�N�g\pleiades\java\11

@rem ���s�y�сA�֘Ajar�t�@�C���̃p�X�L��(*.jar �̂悤�Ƀ��C���h�J�[�h�ł̎w����\�ł�)
set JAR_PATH=./app/*.jar

@rem �o�͐�t�H���_
set OUT_DIR=jre

for /f usebackq %%A in (`%JAVA_HOME%\bin\jdeps --print-module-deps %JAR_PATH%`) do set MODULE=%%A

rem %JAVA_HOME%\bin\jlink --compress=2 --module-path %JAVA_HOME%\jmods --add-modules %MODULE% --output %OUT_DIR%
%JAVA_HOME%\bin\jlink --compress=2 --module-path %JAVA_HOME%\jmods --add-modules %MODULE%,jdk.crypto.ec --output %OUT_DIR%
rem �G���[�����������̂Łujdk.crypto.ec�v��ǉ�

pause
