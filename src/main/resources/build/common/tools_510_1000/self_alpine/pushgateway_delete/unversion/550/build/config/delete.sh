#!/bin/sh
set -x
baseurl=http://pushgateway:9091
for uri in $(curl -sS $baseurl/api/v1/metrics | jq -r '
  .data[].push_time_seconds.metrics[0] |
  select((now - (.value | tonumber)) > 60) |
  (.labels as $labels | ["job", "instance"] | map(.+"/"+$labels[.]) | join("/"))
'); do
  curl -XDELETE $baseurl/metrics/$uri | exit
  echo curl -XDELETE $baseurl/metrics/$uri
done