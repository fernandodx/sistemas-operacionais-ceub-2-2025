@echo off
echo Data e Hora atuais: %date% %time%
echo Usuário logado: %username%
echo Diretório atual: %cd%
echo Espaço livre no disco:
wmic logicaldisk get name, freespace, size
pause
