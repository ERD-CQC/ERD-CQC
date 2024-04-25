import pandas as pd
import matplotlib.pyplot as plt
import numpy as np


x_labels = ['Maintainability', 'Reliability', 'Security', 'Issue', 'Size', 'Complexity']  # X-axis labels (dimension names)
y_labels = ['C-1', 'C-2', 'C-3', 'C-4', 'C-5', 'C-6', 'C-7', 'C-8',
            'O-1', 'O-2', 'O-3', 'O-4', 'O-5', 'O-6', 'O-7', 'O-8']  # Y-axis labels (project names)

excel_file = '../data.xlsx'
df = pd.read_excel(excel_file, header=None)
z_values = df.values
print(z_values)
font = {'family': 'Times new Roman',
        'weight': 'normal',
        'size': 12}

plt.rc('font', **font)

# Creating the heatmap
plt.figure(figsize=(10, 6))
heatmap = plt.imshow(z_values, cmap='YlOrRd', aspect='auto')
plt.colorbar(heatmap)
plt.xticks(np.arange(len(x_labels)), x_labels, rotation=0, ha='center')
plt.yticks(np.arange(len(y_labels)), y_labels)
plt.grid(False)

plt.show()
