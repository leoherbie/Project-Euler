; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;
; What is the 10001st prime number?

; first attempt
(defn factor [f n]
  "how many times does is f a factor of n. returns nil if not a factor"
  (let [t (/ n f)] (if (ratio? t) nil t)))

;FIXME this method needs to be improved badly!
(defn prime? [n]
  "is a number a prime number"
  (cond
    (= n 1) false
    (and (even? n) (> n 2)) false
    (= n 2) true
    true (not-any? #(factor % n) (range 3 (- n 1)))))

(defn find-nth-prime [n]
  "finds the nths prime. n >= 1"
  ;special case
  (if (or (= n 2) (= n 3))
    (- n 1)
    (loop [num-primes-found 2 last-num-processed 3]
      (let [cur-num (+ last-num-processed 2) prime (prime? cur-num)]
        (cond
          (and prime (= (inc num-primes-found) n)) cur-num
          prime (recur (inc num-primes-found) cur-num)
          (not prime) (recur (identity num-primes-found) cur-num))))))

(println (time (find-nth-prime 10001)))