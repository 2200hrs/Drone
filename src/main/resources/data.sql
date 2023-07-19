-- Define the Drone table
CREATE TABLE Drone (
  serial_number VARCHAR(100) NOT NULL,
  model VARCHAR(50) NOT NULL,
  weight_limit DOUBLE NOT NULL,
  battery_capacity DOUBLE NOT NULL,
  state VARCHAR(50) NOT NULL,
  PRIMARY KEY (serial_number)
);

-- Insert some dummy data into the Drone table
INSERT INTO Drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('SN001', 'MODEL_A', 100.0, 50.0, 'IDLE');

INSERT INTO Drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('SN002', 'MODEL_B', 200.0, 75.0, 'IDLE');

INSERT INTO Drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('SN003', 'MODEL_C', 150.0, 80.0, 'IDLE');

INSERT INTO Drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('SN004', 'MODEL_A', 120.0, 60.0, 'IDLE');

INSERT INTO Drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('SN005', 'MODEL_B', 180.0, 70.0, 'IDLE');

INSERT INTO Drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('SN006', 'MODEL_C', 130.0, 85.0, 'IDLE');

INSERT INTO Drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('SN007', 'MODEL_A', 110.0, 55.0, 'IDLE');

INSERT INTO Drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('SN008', 'MODEL_B', 190.0, 65.0, 'IDLE');

INSERT INTO Drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('SN009', 'MODEL_C', 140.0, 90.0, 'IDLE');

INSERT INTO Drone (serial_number, model, weight_limit, battery_capacity, state)
VALUES ('SN010', 'MODEL_A', 130.0, 75.0, 'IDLE');

-- Define the Medication table
CREATE TABLE Medication (
  code VARCHAR(50) NOT NULL,
  name VARCHAR(100) NOT NULL,
  weight DOUBLE NOT NULL,
  image BLOB,
  PRIMARY KEY (code)
);

-- Insert some dummy data into the Medication table
INSERT INTO Medication (code, name, weight, image)
VALUES ('CODE_A', 'MED_A', 10.0, null);

INSERT INTO Medication (code, name, weight, image)
VALUES ('CODE_B', 'MED_B', 20.0, null);

INSERT INTO Medication (code, name, weight, image)
VALUES ('CODE_C', 'MED_C', 15.0, null);

INSERT INTO Medication (code, name, weight, image)
VALUES ('CODE_D', 'MED_D', 25.0, null);

INSERT INTO Medication (code, name, weight, image)
VALUES ('CODE_E', 'MED_E', 12.0, null);

INSERT INTO Medication (code, name, weight, image)
VALUES ('CODE_F', 'MED_F', 18.0, null);

INSERT INTO Medication (code, name, weight, image)
VALUES ('CODE_G', 'MED_G', 8.0, null);

INSERT INTO Medication (code, name, weight, image)
VALUES ('CODE_H', 'MED_H', 22.0, null);

INSERT INTO Medication (code, name, weight, image)
VALUES ('CODE_I', 'MED_I', 17.0, null);

INSERT INTO Medication (code, name, weight, image)
VALUES ('CODE_J', 'MED_J', 23.0, null);