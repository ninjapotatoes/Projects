FROM python:3.10

WORKDIR /app
COPY requirements.txt requirements.txt
RUN pip3 install --no-cache-dir -r requirements.txt

COPY . .

CMD ["python", "demo.py"]

#tutorial then goes into code engine so i can't repeat locally, can ref the webpage though in tutorial folder