import socket
import platform
import psutil

from hosts.host_info import HostInfo


class LinuxHost(HostInfo):

    def get_hardware_info(self):

        self.hostname = socket.gethostname()

        self.cpu = platform.processor()

        self.memory = (
            f"{round(psutil.virtual_memory().total / (1024 ** 3), 2)} GB"
        )

        self.ip = socket.gethostbyname(socket.gethostname())

        self.disk_size = (
            f"{round(psutil.disk_usage('/').total / (1024 ** 3), 2)} GB"
        )