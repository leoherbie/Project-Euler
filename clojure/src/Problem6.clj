; The sum of the squares of the first ten natural numbers is,
; 1² + 2² + ... + 10² = 385

; The square of the sum of the first ten natural numbers is,
; (1 + 2 + ... + 10)² = 55² = 3025

; Hence the difference between the sum of the squares of the first ten natural numbers and the
; square of the sum is 3025 ? 385 = 2640.

; Find the difference between the sum of the squares of the first one hundred natural numbers and
; the square of the sum.

; first attempt
(println (time (- (Math/pow (apply + (range 1 101)) 2) (apply + (map #(Math/pow % 2) (range 1 101))))))

;******************************************************************************************************
; second attempt (after reading PE solution)
(defn square-of-sum [n]
  (Math/pow (/ (* (+ n 1) n) 2) 2))

(defn sum-of-squares [n]
  (* (/ n 6) (+ (* 2 n) 1) (+ n 1)))

(println (time (- (square-of-sum 100) (sum-of-squares 100))))