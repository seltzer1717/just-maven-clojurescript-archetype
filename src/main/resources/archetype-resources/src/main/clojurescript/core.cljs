#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
(ns ${package}.core)

(defn reverso [halb]
  (.join (.reverse (.split halb "")) ""))
