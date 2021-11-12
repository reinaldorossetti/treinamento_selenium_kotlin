
### elemento input search
<input class="search_query form-control ac_input" type="text" id="search_query_top" name="search_query" placeholder="Search" value="" autocomplete="off">

### elemento button search
<button type="submit" name="submit_search" class="btn btn-default button-search">
			<span>Search</span>
</button>

### elemento product
<a class="button ajax_add_to_cart_button btn btn-default" href="http://automationpractice.com/index.php?controller=cart&amp;add=1&amp;id_product=7&amp;token=e817bb0705dd58da8db074c69f729fd8" rel="nofollow" title="Add to cart" data-id-product="7">
										<span>Add to cart</span>
</a>

````css
#center_column .button-container a[data-id-product]
document.querySelector('#center_column .button-container a[data-id-product]').click()
````

<a class="btn btn-default button button-medium" href="http://automationpractice.com/index.php?controller=order" title="Proceed to checkout" rel="nofollow">
						<span>
							Proceed to checkout<i class="icon-chevron-right right"></i>
						</span>
</a>

````css
#layer_cart .button-container a[title="Proceed to checkout"]
document.querySelector('#layer_cart .button-container a[title="Proceed to checkout"]').click()
````

<h1 id="cart_title" class="page-heading">Shopping-cart summary
			<span class="heading-counter">Your shopping cart contains:
			<span id="summary_products_quantity">2 Products</span>
		</span>
</h1>

````css
#cart_title
document.querySelector('#cart_title').textContent
````