# Python Example: Basic Data Analysis with Pandas
import pandas as pd

# Sample data
data = {'Name': ['Alice', 'Bob', 'Charlie', 'David'],
        'Age': [23, 35, 45, 28],
        'Occupation': ['Engineer', 'Doctor', 'Artist', 'Lawyer']}

df = pd.DataFrame(data)

# Show summary
print(df.describe())

# Filter by age
adults = df[df['Age'] > 30]
print(adults)