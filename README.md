# Odine Marketplace API

## 📌 Proje Açıklaması
Odine Marketplace API, freelancer'lar ve iş ilanlarını yönetmek için geliştirilmiş bir Spring Boot tabanlı RESTful API'dir.
## 🚀 Özellikler
- **Freelancer Yönetimi**
- **İş Yönetimi**
- **Yorum Yönetimi**
- **Docker Desteği**
- **Unit Testler**
- **Swagger API Dokümantasyonu**
- **Postman Koleksiyonu**

- Mesajlaşma Kuyruğu (RabbitMQ/Kafka veya Redis) ile Asenkron İşleme (Yapılmadı)

## 🛠 Teknolojiler
- **Java 17** 
- **Spring Boot 3.4.3**
- **Maven** 
- **PostgreSQL** 
- **Docker & Docker Compose** 
- **Swagger** 
- **JUnit & Mockito**

##  Çalıştırma Adımları
### 1️⃣ **Gerekli Bağımlılıkları Kur**
```sh
./mvnw clean install
```

### 2️⃣ **Uygulamayı Docker ile Çalıştır**
```sh
docker-compose up -d
```

### 3️⃣ **Uygulamayı Manuel Çalıştır (Docker Kullanılmadan)**
```sh
./mvnw spring-boot:run
```

## 📌 API Testleri
**Swagger UI** ile API dökümantasyonuna şu adresten ulaşabilirsiniz:
- **[Swagger UI](http://localhost:8080/swagger-ui.html)**

Postman koleksiyonunu kullanarak API’yi test etmek için:
1. **`postman_collection.json` dosyasını içe aktarın.**
2. Postman üzerinden testleri çalıştırın.

## ✅ Unit Testler
Tüm endpoint’ler için JUnit ve Mockito ile testler yazılmıştır.
Testleri çalıştırmak için şu komutu kullanabilirsiniz:
```sh
./mvnw test
```

## 📌 Branch Yapısı
- **`main`** → Ödevin temel gereksinimlerini içerir
- **`feature/docker-and-tests`** → Docker, unit testler ve Swagger eklenmiştir.

Ödevi tam haliyle görmek için şu branch kullanılmalıdır:  
🔗 [Feature/Docker-and-Tests Branch](https://github.com/Serkan1616/marketplace-api/tree/feature/docker-and-tests)


