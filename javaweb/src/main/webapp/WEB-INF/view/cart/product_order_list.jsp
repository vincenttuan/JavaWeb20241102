<%@page import="javaweb.cart.model.dto.ProductDTO"%>
<%@page import="javaweb.cart.model.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<ProductDTO> productDTOs = (List<ProductDTO>)request.getAttribute("productDTOs");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品訂單列表管理</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style>
			#preview {
				margin-top: 10px;
				max-width: 200px;
				max-height: 200px;
				border: 1px solid #ddd;
				padding: 5px;
			}
		</style>
	</head>
	<body>
		<!-- menu bar -->
		<%@ include file="/WEB-INF/view/cart/menu.jspf"  %>
		<!-- content -->
		<div style="padding: 15px" class="pure-form">
			<table>
				<td valign="top">
					<fieldset>
						<legend>商品訂單列表</legend>
						<table class="pure-table">
							<thead>
								<tr>
									<th>商品ID</th><th>商品名稱</th><th>商品價格</th>
									<th>商品庫存</th><th>商品照片</th><th>加入購物車</th>
								</tr>
							</thead>
							<tbody>
								<% for(ProductDTO productDTO : productDTOs) { %>
									<tr onmouseover="this.style.backgroundColor='#E0E0ff'" 
									    onmouseout="this.style.backgroundColor=''">
										<td>
											<img width="100" src='data:image/png;base64,<%=productDTO.getImageBase64() %>'>
										</td>
										<td align="top">
											<%=productDTO.getProductName() %>(No.<%=productDTO.getProductId() %>)<p />
											$<%=productDTO.getPrice() %><p />
											庫存:<%=productDTO.getQty() %><p />
											<a href="/javaweb/product/add/cart?productId=<%=productDTO.getProductId() %>">加入購物車</a>
										</td>
									</tr>
								<% } %>
							</tbody>
						</table>
					</fieldset>
				</td>
			</table>
			
		</div>
		
		<script>
		    document.getElementById('productImage').addEventListener('change', function(event) {
		        const fileInput = event.target;
		        const file = fileInput.files[0];
		        const fileName = file?.name || ''; // 獲取檔案名稱
		        const regex = /^.(\d+)([^\d].*[^\d])(\d+)\.png$/; // 假設格式為 任意字元<庫存數字><商品名稱><價格>.png
		        const match = fileName.match(regex);

		        if (match) {
		            const [_, qty, name, price] = match; // 解構正則匹配的結果
		            document.getElementById('qty').value = qty; // 庫存數字
		            document.getElementById('productName').value = name;  // 商品名稱
		            document.getElementById('price').value = price; // 商品價格
		        } else {
		            //alert('檔名格式不符合規範，請使用正確格式！');
		            document.getElementById('qty').value = '';
		            document.getElementById('productName').value = '';
		            document.getElementById('price').value = '';
		        }

		        // 預覽照片
		        if (file) {
		            const reader = new FileReader();
		            reader.onload = function(e) {
		                const preview = document.getElementById('preview');
		                preview.src = e.target.result; // 將讀取的圖片內容設定為 img 的 src
		                preview.style.display = 'block'; // 顯示圖片
		            };
		            reader.readAsDataURL(file); // 讀取檔案內容
		        } else {
		            document.getElementById('preview').style.display = 'none'; // 如果沒有圖片則隱藏預覽
		        }
		    });
		</script>
		
	</body>
</html>