import platform

from hosts.linux_host import LinuxHost
from hosts.windows_host import WindowsHost


def main():

    operating_system = platform.system()

    if operating_system == "Linux":

        host = LinuxHost()

    elif operating_system == "Windows":

        host = WindowsHost()

    else:
        raise Exception(
            f"Unsupported Operating System: {operating_system}"
        )

    host.get_hardware_info()

    host.display_hardware_info()


if __name__ == "__main__":
    main()