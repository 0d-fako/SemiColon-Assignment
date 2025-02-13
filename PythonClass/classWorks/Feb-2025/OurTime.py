class OurTime:
    def __init__(self, hours, minutes, seconds):
        self.hours = hours
        self.minutes = minutes
        self.seconds = seconds



    @property
    def hours(self):
        return self._hour


    @hours.setter
    def hours(self, hour):
        if hour < 0 or hour > 23:
            raise ValueError("hour must be between 0 and 23")
        self_hours = hour
