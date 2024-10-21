import csv

class ReadAndWriteData:
    def __init__(self, file_name):
        self.file_name = file_name
        self.data = []

    def read_csv(self):
        with open(self.file_name, mode='r', newline='') as file:
            reader = csv.DictReader(file)
            for row in reader:
                self.data.append(row)

    def display_data(self):
        for entry in self.data:
            print("Name: {entry['Name']}, SkillSet: {entry['SkillSet']}, Experience: {entry['Experience']}")

if __name__ == "__main__":
    csv_file = 'Data.csv'
    rw_data = ReadAndWriteData(csv_file)
    rw_data.read_csv()
    rw_data.display_data()
