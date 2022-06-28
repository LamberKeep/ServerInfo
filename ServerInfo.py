import psutil
import requests

cpu = round(psutil.cpu_percent(), 1)
ram = round(psutil.virtual_memory().percent, 1)
ip = requests.get('http://icanhazip.com').text

print(f"CPU: {cpu}%")
print(f"RAM: {ram}%")
print(f"IP: {ip}")