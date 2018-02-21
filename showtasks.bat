call gradlew build
if "%ERRORLEVEL%" == "0" goto chrome
echo.
echo GRADLEW BUILD has errors - breaking work
goto fail

:chrome
start "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open chrome browser
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.