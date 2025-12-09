class Car:

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " is moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped")

car1 = Car("Mahindra", "3XO", "2025", "Automatic", "Black")
car2 = Car("Tata", "Curv", "2025", "Manual", "Orange")
car3 = Car("Hyundai", "Venu", "2025", "Manual", "Blue")

car2.accelerate()
car2.stop()

car1.accelerate()
car3.stop()