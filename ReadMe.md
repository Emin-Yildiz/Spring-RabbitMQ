# RabbitMQ

## RabbitMQ nedir ?

RabbitMQ açık kaynak kodlu bir mesaj kuyruk sistemidir. Bu sistem FIFO(First In First Out) prensibini temel alır. Bu sayede mesajlar sıraya gönderildikleri sıra ile alıcılara iletilirler.

FIFO mekanizması, mesajların doğru bir sıra ile iletilmesi ve uygulamalar arasında tutarlı bir veri alışverişi sağlar. RabbitMQ bu yüzden mesajlar arasındaki doğru sırayı korumak için FIFO yapısı kullanır.

## RabbitMQ Özellikleri

- RabbitMQ, dağıtılmış sistemlerde uygulamalar arasındaki mesaj ve veri iletişimini kolaylaştırır.
- RabbitMQ asenkron bir yapı olduğu için yoğun iş yüklerinin işlenmesinde kullanılır. Bu sayede işlem arka planda gerçekleşir. Bu uygulamaların daha hızlı ve performanslı çalışmasına olanak sağlar.
- RabbitMQ, farklı uygulamaların ve platformların birbirleri ile haberleşmesini sağlayarak entegrasyon süreçlerini basitleştirir.
- RabbitMQ, MQTT, AMQP, STOMP gibi bir çok mesajlaşma protokollerini destekler.
- RabbitMQ, sağladığı güvenlik imkanları ile veri kaybının önüne geçmektedir.

## Neden RabbitMQ Kullanmalıyız

Bir uygulamamız olduğunu varsayalım. Bu uygulamaya kullanıcı bir istek attığı zaman, bu isteğe anlık cevap veremiyorsak yada bu istek sonucu yoğun zaman alacak bir işlem gerçekleşecek ise isteğin karşılığını arka planda asenkron bir şekilde işleyip uygulamanın işlem yoğunluğunu azaltmamız gerektiği #durumlarda kullanılır.

### Avantajlar

- **Kolay Kullanım:** RabbitMQ, basit kurulum ve kullanımı ile bilinir.
- **Geniş Protokol Desteği:** AMQP, MQTT, STOMP gibi farklı protokollerle uyumludur.
- **Esneklik:** Farklı senaryolara ve kullanım durumlarına uygun esnek yapılandırma seçenekleri sunar.
- **Topluluk Desteği:** Geniş bir açık kaynak topluluğu ve belgelendirmeye sahiptir.

### Dezavantajlar

- **Performans Sınırlamaları:** Rakiplerine göre yüksek işlem yüklerinde performansı daha düşük olabilir.
- **Kapsüllü Depolama Eksikliği:** Kafka gibi dayanıklı ve kapsüllü depolama sunmaz.

## RabbitMQ'nun İşleyişi

RabbitMQ, **Publisher(Verici)** ve **Consumer(Alıcı)** ve **Queue(Kuyruk)** olmak üzere 3'e ayrılır.

- Publisher: RabbitMQ kuyruğuna mesaj gönderen uygulama/kişidir.
- Queue: Publisher'dan gelen mesajların sıralandığı yapıdır.
- Consumer: Kuyrukda sıralanan mesajları alıp işlem yapan uygulama/kişidir.

## RabbitMQ Kurulumu

RabbitMQ'yu bilgisayarımıza docker üzerinden kurucaz.

- Öncelikle docker hub üzerinden rabbitmq image'ini indirmemiz gerekli.

```docker
docker pull rabbitmq:3.12.2-management
```

- Sonrasında ise indirdiğimiz image'i kullanarak bir container ayağa kaldırmalıyız.(bilgisayarımızın 15672 no'lu portu ile rabbitmq'nun arayüzüne erişim sağlarız. 5672 numaralı port ise rabbitmq'da kullanılan ana mesajlaşma portudur.)

```docker
docker run -d --hostname rabbit --name rabbit-server -p 15672:15672 -p 5672:5672 rabbitmq:3.12.2-management
```
