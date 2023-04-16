import pandas as pd
file_errors_location = 'OysteinsRoom-230210-2333.xlsx'
df = pd.read_excel(file_errors_location)
print(df)