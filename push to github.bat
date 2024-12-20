@echo off
REM Set the log file path
set log_file=C:\Users\Admin\Documents\Eclipse\Java1\git_push_log_java1.txt

REM Record the start time of the task
echo Task started at %date% %time% >> "%log_file%"

REM Change to the target folder where the Git repository is located
cd /d C:\Users\Admin\Documents\Eclipse\Java1 >> "%log_file%" 2>&1

REM Initialize the Git repository (if not already initialized)
git init >> "%log_file%" 2>&1

REM Add all changes
git add . >> "%log_file%" 2>&1

REM Commit with a default message
git commit -m "first commit" >> "%log_file%" 2>&1

REM Add the remote repository (if not already set up)
git remote add origin https://github.com/Krish1971997/Javanew.git >> "%log_file%" 2>&1 || echo Remote origin already exists. >> "%log_file%"

REM Push changes to the remote repository
git push origin master >> "%log_file%" 2>&1

REM Record the end time of the task
echo Task completed at %date% %time% >> "%log_file%"

pause
