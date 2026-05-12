from abc import ABC, abstractmethod
import json


class HostInfo(ABC):

    def __init__(self):
        self.hostname = None
        self.cpu = None
        self.memory = None
        self.ip = None
        self.disk_size = None

    @abstractmethod
    def get_hardware_info(self):
        """
        Fetch hardware information from the system.
        Must be implemented by subclasses.
        """
        pass

    def display_hardware_info(self):
        """
        Display hardware information in JSON format.
        """

        hardware_info = {
            "hostname": self.hostname,
            "cpu": self.cpu,
            "memory": self.memory,
            "ip_address": self.ip,
            "disk_size": self.disk_size
        }

        print(json.dumps(hardware_info, indent=4))