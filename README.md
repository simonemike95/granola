# Granola
Granola is a set of scripts to be run on the OSBot client.


Project setup help can be found [here](https://osbot.org/forum/topic/58775-a-beginners-guide-to-writing-osbot-scripts-where-to-get-started-by-apaec/?__cf_chl_jschl_tk__=34dc0657cc43aa6dc3df3ecb00d228afcf71e507-1593698280-0-AeIx0Dz4GGydpjo-q4EGHPrntqpTEjok9zlfGmUUvOJruJXH8m3eySCO2jgmooWYlMNntcBWpCmIQr_dSJLrWAXmmByo73tYoj6BNs2c-1bWo7DOUvPH2q247V5AJhA_w8VyGvtMOgQhvKXWuDLU3B8WrUilujfHfbrTkJNX12nIL200CG0hAKumowYWdKSiX5pxtbEWRq9niMRH0C20rwe_QCaXwmF38WhsHqtbTZiJOQG9zztSRM7dUfEhV29ZpiKl9DRLl4Ngw0y5aEtLjesDZ_A_JcSjNvHq1OktFmtGkd7LK3dOVXKjN0YNekYXQd-bBfR4OlvCUoBnRbeuTort1m-_45ATe015iBFDo2MmL95mlEHuGQCFXRK66GUZntBMnIsKHtt03dJsZNs8V2k).

## Setting up Eclipse for building
1. Right-click the project in the left pane and select properties
2. Select "Java Build Path" in the left pane
3. Click "Add library" on the right
4. Select "JRE System Library" and click next
5. Select JavaSE-1.8 from the "Execution environment" dropdown and click finish

## Exporting scripts
Follow the 'Compiling the script' from [here](https://osbot.org/forum/topic/58775-a-beginners-guide-to-writing-osbot-scripts-where-to-get-started-by-apaec/?__cf_chl_jschl_tk__=34dc0657cc43aa6dc3df3ecb00d228afcf71e507-1593698280-0-AeIx0Dz4GGydpjo-q4EGHPrntqpTEjok9zlfGmUUvOJruJXH8m3eySCO2jgmooWYlMNntcBWpCmIQr_dSJLrWAXmmByo73tYoj6BNs2c-1bWo7DOUvPH2q247V5AJhA_w8VyGvtMOgQhvKXWuDLU3B8WrUilujfHfbrTkJNX12nIL200CG0hAKumowYWdKSiX5pxtbEWRq9niMRH0C20rwe_QCaXwmF38WhsHqtbTZiJOQG9zztSRM7dUfEhV29ZpiKl9DRLl4Ngw0y5aEtLjesDZ_A_JcSjNvHq1OktFmtGkd7LK3dOVXKjN0YNekYXQd-bBfR4OlvCUoBnRbeuTort1m-_45ATe015iBFDo2MmL95mlEHuGQCFXRK66GUZntBMnIsKHtt03dJsZNs8V2k).

Note: Rather than right-clicking the entire project. You must right-click the specific class that corrsponds with the given script you want to export.

The exported jar file is then need to be places in the OSBot scripts directory

Windows: `C:/Users/<username>/OSBot/Scripts`

Mac: `/Users/<username>/OSBot/Scripts`
