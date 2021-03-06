<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

</head>
<body>
	<div class="card bg-light mb-6" style="max-width: 80rem; margin: 80px;">
		<div class="card-header">Products
			<button type="button" class="btn btn-primary float-right" data-toggle="modal"
				data-target="#exampleModal">Add Product</button>
		</div>
		<div class="card-body">
			<table style="margin-top: 20px;" class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Product Name</th>
						<th scope="col">Category Name</th>
						<th scope="col">Bar code</th>
						<th scope="col">Price</th>
						<th scope="col">Size</th>
						<th scope="col">Quantity</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="product">
						<tr>
							<td>${product.productName}</td>
							<td>${product.category.categoryName}</td>
							<td>${product.barcode}</td>
							<td>${product.price}</td>
							<td>${product.size}</td>
							<td>${product.quantity}</td>
							<td>
								<button onclick="getUpdateModal(${product.productId}, '${product.productName}', ${product.category.categoryId}, '${product.barcode}', ${product.price}, ${product.size }, ${product.quantity} );" type="button" class="btn btn-outline-primary">
									<svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-pencil" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  										<path fill-rule="evenodd"
											d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z" />
									</svg>
								</button> <a href="/products/delete/${product.productId}"
								type="button" class="btn btn-outline-danger"> <svg
										width="1.5em" height="1.5em" viewBox="0 0 16 16"
										class="bi bi-trash" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
	  			<path
											d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
	  			<path fill-rule="evenodd"
											d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
			</svg>
							</a>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add New
						Product</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form id="productForm" action="/products/save" method="post">
					<div class="modal-body">
						<input type="hidden" id="inputProductId" name="productId">
						<div class="form-group">
							<label for="inputProductName" class="col-form-label">Product
								Name</label> <input name="productName" type="text" class="form-control"
								id="inputProductName">
						</div>
						<div class="form-group">
							<label for="inputCategory" class="col-form-label">Category</label> 
							<select id="inputCategory" name="category" class="form-control">
							<option selected value='' disabled>Select Category</option>
								<c:forEach items="${categories}" var="category">
									<option value='${category.categoryId}'>${category.categoryName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="inputBarcode" class="col-form-label">Barcode</label>
							<input type="text" name="barcode" class="form-control" id="inputBarcode">
						</div>
						<div class="form-group">
							<label for="inputPrice" class="col-form-label">Price</label>
							<input type="number" name="price" class="form-control" id="inputPrice">
						</div>
						<div class="form-group">
							<label for="inputSize" class="col-form-label">Size</label>
							<input type="number" name="size" class="form-control" id="inputSize">
						</div>
						<div class="form-group">
							<label for="inputQuantity" class="col-form-label">Quantity</label>
							<input type="number" name="quantity" class="form-control" id="inputQuantity">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button id="submitBtn" type="submit" class="btn btn-primary">Save</button>
					</div>

				</form>
			</div>
		</div>
	</div>

	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
		
	<script type="text/javascript">
		function getUpdateModal(id,productName,categoryId, barcode, price, size, quantity) {
			$("#exampleModal").modal('show');
			$("#inputProductId").val(id);
			$("#inputProductName").val(productName);
			$("#inputBarcode").val(barcode);
			$("#inputPrice").val(price);
			$("#inputSize").val(size);
			$("#inputQuantity").val(quantity);
			$("#exampleModalLabel").html("Update Product");
			$("#inputCategory").val(categoryId);
			$("#productForm").attr("action", "/products/update");
			$("#submitBtn").html("Update");
			
		}
	</script>
</body>
</html>