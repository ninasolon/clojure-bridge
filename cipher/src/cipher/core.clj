(ns cipher.core)

(defn to-int [char]
  (- (int char) (int \a)))

(defn to-char [i]
  (char (+ i (int \a))))

(defn shift [c k o]
  (to-char (mod (o (to-int c) k) 26)))

;(defn caesar-encrypt [w k]
;  (clojure.string/join (mapv #(shift % k +) (seq w)))
;  )

(defn caesar-encrypt [w k]
  (->> w
       seq
       (mapv #(shift % k +))
       clojure.string/join))

(defn caesar-decrypt [w k]
  (clojure.string/join (mapv #(shift % k -) (seq w))))

;(defn shift+ [c k]
;      (shift c k +))
;
;(defn shift- [c k]
;  (shift c k -))
;
;(defn caesar-encrypt [w k]
;  (clojure.string/join (mapv #(shift+ % k) (seq w)))
;  )
;
;(defn caesar-decrypt [w k]
;  (clojure.string/join (mapv #(shift- % k) (seq w)))
;  )
