app.controller("account-ctrl" , function($scope , $http){
	$scope.items = [];
	$scope.form = {};
	
	$scope.initialize = function(){
		//load account
		$http.get("/rest/accounts/load").then(resp => {
			$scope.items = resp.data ;		
		})
	}
	
	//Xoa form
	$scope.reset = function(){
		$scope.form = {
			image:'cloud-upload.jpg'
		};
	},
	
	//Khởi đầu
	$scope.initialize();
	
	//Hiển thị lên form
	$scope.edit = function(item){
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
	}
	
	//Thêm mới tài khoản
	$scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/accounts` , item).then(resp => {
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm tài khoản thành công");
		}).catch(error => {
			alert("Lỗi thêm mới tài khoản!");
			console.log("Error" , error);
		});
	}
	
	
	//Cập nhật tài khoản
	$scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/accounts/${item.username}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.username == item.username);
			$scope.items[index] = item ;
			alert("Cập nhật tài khoản thành công !");
		}).catch(error => {
			alert("Lỗi cập nhật tài khoản ");
			console.log("Error", error);
		});
	}
	
	//Xóa tài khoản
	$scope.delete = function(item){
		$http.delete(`/rest/accounts/${item.username}`,item).then(resp =>{
			var index = $scope.items.findIndex(p => p.username == item.username);
			$scope.items.splice(index,1);
			$scope.reset();
			alert("Xóa tài khoản thành công ");
		}).catch(error => {
			alert("Lỗi xóa sản phẩm!");
			console.log("Error" , error);
		})
	}
	
	//Upload hình
	$scope.imageChanged = function(files){	
			var data = new FormData();
			data.append('file',files[0]);
			$http.post('/rest/upload/photo',data,{
				transformRequest:angular.identity,
				headers:{'Content-Type':undefined}
			}).then(resp => {
				$scope.form.photo = resp.data.name;
			}).catch(error => {
				alert("Lỗi upload hình ảnh");
				console.log("Error" , error)
			})
	}
	
	//Tìm theo tên
	$scope.findName = function(){
		var item = angular.copy($scope.form);
		$http.get(`/rest/accounts/findname/${item.fullname}`).then(resp => {
			$scope.items = angular.copy(resp.data);
		})
	}
	
	//Phân trang
	$scope.pager={
	page : 0 ,
	size : 10 ,
	get items(){
		var start = this.page * this.size ;
		return $scope.items.slice(start , start + this.size);
	},
	get count(){
		return Math.ceil(1.0 * $scope.items.length / this.size);
	},
	first(){
			this.page = 0 ;
		},
		prev(){
			this.page -- ;
			if(this.page < 0){
				this.last();
			}
		},
		next(){
			this.page++;
			if(this.page >= this.count){
				this.first();
			}
		},
		last(){
			this.page = this.count-1 ;
		}
	}
})
	