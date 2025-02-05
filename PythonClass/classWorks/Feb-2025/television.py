class Television:
    def __init__(self):
        self.__is_on = False
        self.__previous_volume = 0
        self.__volume_level = self.__previous_volume
        self.__channel_level = 0


    def turn_on(self):
        self.__is_on = True


    def turn_off(self):
        self.__is_on = False

    def get_volume(self):
        return self.__volume_level

    def increase_volume(self ):
        if self.__is_on and self.__volume_level < 10:
            self.__volume_level+=1

    def decrease_volume(self):
        if self.__is_on and self.__volume_level > 0  :
            self.__volume_level-=1