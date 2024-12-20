@echo off
echo Task started at %date% %time% >> git_task_log.txt
git init >> git_task_log.txt 2>&1
git add . >> git_task_log.txt 2>&1
git commit -m "first commit" >> git_task_log.txt 2>&1
git remote add origin https://github.com/Krish1971997/Javanew.git >> git_task_log.txt 2>&1
git push origin master >> git_task_log.txt 2>&1
echo Task completed at %date% %time% >> git_task_log.txt
pause
