import pandas as pd
import logging
import os

#benchmark 、 DepCQC 、Sonar 
def compare_ben_CQC(input_dir, input_cqm_excel, input_cqc_excel, output_dir, input_name ,item):
    logging.basicConfig(
        level=logging.INFO, format="%(asctime)s - %(levelname)s - %(message)s"
    )
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)
        logging.info(f"Created directory {output_dir}")

    output_loubao_excel = f"{output_dir}\\{input_name}_loubao.xlsx"
    output_loubao_number_excel = f"{output_dir}\\{input_name}_loubao_number.xlsx"
    output_loubao_name_excel = f"{output_dir}\\{input_name}_loubao_name.xlsx"

    output_wubao_excel = f"{output_dir}\\{input_name}_wubao.xlsx"
    output_wubao_number_excel = f"{output_dir}\\{input_name}_wubao_number.xlsx"
    output_wubao_name_excel = f"{output_dir}\\{input_name}_wubao_name.xlsx"

    output_pipei_excel = f"{output_dir}\\{input_name}_match.xlsx"
    output_pipei_numbae_excel = f"{output_dir}\\{input_name}_match_number.xlsx"
    output_pipei__name_excel = f"{output_dir}\\{input_name}_match_name.xlsx"

    cqm_df = pd.read_excel(input_cqm_excel)
    duplicates = cqm_df.duplicated(subset=item)
    unique_rows = cqm_df[~duplicates]
    unique_count = len(unique_rows)
    cqc_df = pd.read_excel(input_cqc_excel)
    duplicates = cqc_df.duplicated(subset=['File', 'Line', 'Rule'])
    unique_rows = cqc_df[~duplicates]
    unique_count = len(unique_rows)
    cqm_set = set()
    cqm_set_line_map = dict()
    for i, row in cqm_df.iterrows():
        file = row[item[0]]
        line = row[item[1]]
        rule = row[item[2]]
        cqm_set.add((file, line, rule))
        key = f"{file}_{line}_{rule}"
        if key in cqm_set_line_map:
            cqm_set_line_map[key].append(i)
        else:
            cqm_set_line_map[key] = [
                i,
            ]
    cqc_set = set()
    cqc_set_line_map = dict()
    for i, row in cqc_df.iterrows():
        file = row["File"]
        file = file.replace(input_dir, "")
        file = file.replace("\\","/")
        line = row["Line"]
        rule = row["Rule"]
        cqc_set.add((file, line, rule))
        key = f"{file}_{line}_{rule}"
        if key in cqc_set_line_map:
            cqc_set_line_map[key].append(i)
        else:
            cqc_set_line_map[key] = [
                i,
            ]
    loubao_set = cqm_set - cqc_set
    wubao_set = cqc_set - cqm_set
    pipei_set = cqm_set & cqc_set

    
def benchmark_ben_sonar( input_ben_excel, input_sonar_excel, output_dir, input_name , item):
    logging.basicConfig(
        level=logging.INFO, format="%(asctime)s - %(levelname)s - %(message)s"
    )
    logging.info("Start of program")
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)
        logging.info(f"Created directory {output_dir}")
    output_loubao_excel = f"{output_dir}\\{input_name}_loubao.xlsx"
    output_loubao_number_excel = f"{output_dir}\\{input_name}_loubao_number.xlsx"
    output_loubao_name_excel = f"{output_dir}\\{input_name}_loubao_name.xlsx"

    output_wubao_excel = f"{output_dir}\\{input_name}_wubao.xlsx"
    output_wubao_number_excel = f"{output_dir}\\{input_name}_wubao_number.xlsx"
    output_wubao_name_excel = f"{output_dir}\\{input_name}_wubao_name.xlsx"

    output_pipei_excel = f"{output_dir}\\{input_name}_match.xlsx"
    output_pipei_numbae_excel = f"{output_dir}\\{input_name}_match_number.xlsx"
    output_pipei__name_excel = f"{output_dir}\\{input_name}_match_name.xlsx"
    ben_df = pd.read_excel(input_ben_excel)
    sonar_df = pd.read_excel(input_sonar_excel)
    duplicates = sonar_df.duplicated(subset=item)
    unique_rows = sonar_df[~duplicates]
    unique_count = len(unique_rows)
    ben_set = set()
    ben_set_line_map = dict()
    for i, row in ben_df.iterrows():
        file = row[item[0]]
        line = row[item[1]]
        rule = row[item[2]]
        ben_set.add((file, line, rule))
        key = f"{file}_{line}_{rule}"
        if key in ben_set_line_map:
            ben_set_line_map[key].append(i)
        else:
            ben_set_line_map[key] = [
                i,
            ]

    sonar_set = set()
    sonar_set_line_map = dict()
    for i, row in sonar_df.iterrows():
        file = row[item[0]]
        line = row[item[1]]
        rule = row[item[2]]
        sonar_set.add((file, line, rule))
        key = f"{file}_{line}_{rule}"
        if key in sonar_set_line_map:
            sonar_set_line_map[key].append(i)
        else:
            sonar_set_line_map[key] = [
                i,
            ]
    loubao_set = ben_set - sonar_set
    wubao_set = sonar_set - ben_set
    pipei_set = ben_set & sonar_set


if __name__ == "__main__":
    #benchmark
    input_ben = r"D:\Test\RQ2\push_out-master\benchmark.xlsx"
    # CQC
    input_cqc = r"D:\Test\RQ2\push_out-master\push.xlsx"
    # Sonar
    input_sonar = r"D:\Test\RQ2\\push_out-master\CQM_push_out.xlsx"

    output_directory_1 = r"D:\Test\RQ2\push_out-master\result_1"

    output_directory_2 = r"D:\Test\RQ2\push_out-master\result_2"
    input_name = "push"
    input_dir = "D:\Test\project7_push_out-master\push_out-master\\"

    item = ["path", "issue_line", "DepCQC"]
    compare_ben_CQC(input_dir, input_ben, input_cqc, output_directory_1, input_name,item)

    benchmark_ben_sonar(input_ben, input_sonar, output_directory_2, input_name,item)