import pandas as pd

def match(Sonar_excel , output_excel):
    df1 = pd.read_excel(Sonar_excel)
    df2 = pd.read_excel(r'..\rule_mapping.xlsx')
    merged_df = pd.merge(df1, df2, on='rule', how='rule')
    for index, row in merged_df.iterrows():
        original_index = merged_df.index[merged_df['rule'] == row['rule']]
        df1.loc[original_index, 'author'] = row['author']
        df1.loc[original_index, 'type'] = row['type']
        df1.loc[original_index, 'SonarClassName'] = row['SonarClassName']
        df1.loc[original_index, 'rule_key'] = row['rule_key']
        df1.loc[original_index, ('CQCClassName')] = row['CQCClassName']
        df1.loc[original_index, 'rule'] = row['rule']

    df1.to_excel(output_excel, index=False)


if __name__ == '__main__':
    Sonar_excel = r"D:\Sonar_Vuze.xlsx"
    output_excel = r"D:\Match_Vuze.xlsx"
    match(Sonar_excel , output_excel)
