import groovy.xml.*

def markupBuilder = new StreamingMarkupBuilder()
def xml = markupBuilder.bind { builder -&gt;
 client {
  name 'mrhaki'
  fullName 'Hubert A. Klein Ikkink'
  buildAddress builder, 'Main St.', 42, 'Ducktown'
  delivery {
      buildAddress builder, 'Main Av.', 101, 'Springfield'
      remarks 'During office hours'
  }
  buildItems builder
 }
}

def buildAddress(builder, streetName, number, city) {
 builder.address {
  street streetName
  houseNumber number
  buildCity builder, city
 }
}

def buildCity(builder, city) {
 builder.city city
}

def buildItems(builder) {
    builder.items {
     ['iPod', 'eBook'].eachWithIndex { product, index -&gt;
      item(id: index + 1) {
       name "Item $product"
      }
     }
    }
}

assert '''&lt;?xml version="1.0" encoding="UTF-8"?&gt;
&lt;client&gt;
  &lt;name&gt;mrhaki&lt;/name&gt;
  &lt;fullName&gt;Hubert A. Klein Ikkink&lt;/fullName&gt;
  &lt;address&gt;
    &lt;street&gt;Main St.&lt;/street&gt;
    &lt;houseNumber&gt;42&lt;/houseNumber&gt;
    &lt;city&gt;Ducktown&lt;/city&gt;
  &lt;/address&gt;
  &lt;delivery&gt;
    &lt;address&gt;
      &lt;street&gt;Main Av.&lt;/street&gt;
      &lt;houseNumber&gt;101&lt;/houseNumber&gt;
      &lt;city&gt;Springfield&lt;/city&gt;
    &lt;/address&gt;
    &lt;remarks&gt;During office hours&lt;/remarks&gt;
  &lt;/delivery&gt;
  &lt;items&gt;
    &lt;item id="1"&gt;
      &lt;name&gt;Item iPod&lt;/name&gt;
    &lt;/item&gt;
    &lt;item id="2"&gt;
      &lt;name&gt;Item eBook&lt;/name&gt;
    &lt;/item&gt;
  &lt;/items&gt;
&lt;/client&gt;
''' == XmlUtil.serialize(xml)
