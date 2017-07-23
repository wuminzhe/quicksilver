(ns quicksilver.book)

; key是价格，通过价格进行排序
(def ask-book (atom (sorted-map-by <))) ; 卖单，价格低的在前面
(def bid-book (atom (sorted-map-by >))) ; 买单，价格高的在前面

(defn top
  [book]
  (->
    book first last))

(defn decrease
  [book q
    (loop [remaining quantity])])

(defn ask? [order] (= :ask (:type order)))
(defn bid? [order] (= :bid (:type order)))

; 通过 当前订单 和 对手top订单 来判断是否能交易
(defn can-trade?
  [order top-order-of-counter-book]
  (cond
    (nil? top-order-of-counter-book) false
    (ask? order) (<= (:price order) (:price top-order-of-counter-book)) ; if people offer price higher or equal than ask limit
    (bid? order) (>= (:price order) (:price top-order-of-counter-book)))) ;if people offer price lower or equal than bid limit

(defn match
  [order counter-book]
  (let [top (top counter-book)]
    (if (can-trade? order top)
      (let [bindings]
        body))))
