import psutil

def mostrar():
    procesos = psutil.process_iter()
    
    print("lista de procesos:")
    for proceso in procesos: 
        
        print(f"id del proceso{proceso.pid}, El nombre del proceso es: {proceso}\n")

def finalizar(pid):
    try:
        proceso = psutil.Process(pid)
        proceso.terminate()
        print("proceso terminado")
    except psutil.NoSuchProcess:
        print("Error")
        
mostrar()
pidfin= int(input("id del proceso que quieres terminar:"))
finalizar(pidfin)