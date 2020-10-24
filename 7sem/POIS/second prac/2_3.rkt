#lang racket

(define (getYearFromUser)
  (write "Введите год:")
  (newline)
  (read)
)

(define (checkYear year)
  (if (zero? (remainder year 4))
      (write "Этот год високосный")
      (if (zero? (remainder year 100))
          (write "Этот год обычный")
          (if (zero? (remainder year 400))
              (write "Этот год високосный")
              (write "Этот год обычный")
          )
      )
  )
)

(define (checkYourYear)
  (write "Проверим ваш год на високосность.")
  (newline)
  (checkYear (getYearFromUser))
)

(checkYourYear)