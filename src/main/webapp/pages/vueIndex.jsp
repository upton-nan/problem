<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/pages/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>vue信息</title>
</head>
<body>
	<div id="app">{{ message }}</div>
	<div id="app-2">
		<span v-bind:title="message"> 鼠标悬停几秒钟查看此处动态绑定的提示信息！ </span>
	</div>
	<div id="app-3">
		<p v-if="seen">现在你看到我了</p>
	</div>
	<script type="text/javascript">
		var app = new Vue({
			el : '#app',
			data : {
				message : '可以hihi我ihihiw'
			}
		});
		var app2 = new Vue({
			el : '#app-2',
			data : {
				message : '页面加载于 ' + new Date().toLocaleString()
			}
		});
		var app3 = new Vue({
			el : '#app-3',
			data : {
				seen : true
			}
		})
	</script>
	<div id="app-4">
		<ol>
			<li v-for="todo in todos">{{ todo.text }}</li>
		</ol>
	</div>
	<script type="text/javascript">
		var app4 = new Vue({
			el : '#app-4',
			data : {
				todos : [ {
					text : '学习 JavaScript'
				}, {
					text : '学习 Vue'
				}, {
					text : '整个牛项目'
				} ]
			},
			craetd : function() {
				this.$message.error('上传头像图片只能是 JPG 格式!');
			}
		})
	</script>
	<div id="app-5">
		<p>{{ message }}</p>
		<!-- <button v-on:click="reverseMessage">反转消息</button> -->
	</div>
	<script type="text/javascript">
		var vm = new Vue({
			el : '#app-5',
			data : {
				message : 'hello world'
			},
			methods : {
				methodDemo : function() {
					var _this = this;
					_this.message = 'hello world methods demo';
					setTimeout(function() {
						_this.$message.success(_this.message);
					}, 1);
				}
			},
			beforeCreate : function() {
				var _this = this;
				setTimeout(function() {
					_this.$message.success("组件创建前")
				}, 1);
			},
			created : function() {
				var _this = this;
				setTimeout(function() {
					_this.$message.success("组件创建完成");
				}, 1);
				this.methodDemo();
			},
			beforeMount : function() {
				var _this = this;
				setTimeout(function() {
					_this.$message.success("模板编译之前，还没挂载");
				}, 1);
			},
			mounted : function() {
				var _this = this;
				setTimeout(function() {
					_this.$message.success("模板编译之后，已挂载，页面上存在数据展示");
				}, 1);
			},

			beforeUpdate : function() {
				var _this = this;
				setTimeout(function() {
					_this.$message.success("组件更新之前");
				}, 1);
			},
			updated : function() {
				var _this = this;
				setTimeout(function() {
					_this.$message.success("组件更新成功");
				}, 1);
			},
			beforeDestory : function() {
				var _this = this;
				setTimeout(function() {
					_this.$message.success("组件销毁之前");
				}, 1);
			},
			destoryed : function() {
				var _this = this;
				setTimeout(function() {
					_this.$message.success("组件销毁");
				}, 1);
			}
		})
	</script>
	<div id="app-6">
		<p>{{ message }}</p>
		<input v-model="message">
	</div>
	<script type="text/javascript">
		var app6 = new Vue({
			el : '#app-6',
			data : {
				message : 'Hello Vue!'
			}
		})
	</script>
	<script type="text/javascript">
		var service = axios.create({
			baseURL : "",
			withCredentials : true,
			timeout : 1000 * 60 * 5
		})

		/* $(function() {
			service({
				url : $GV.ROOT + "/test/users?id=33333333",
				method : "get",
				data : {}
			}).then(function(res) {
				console.log(res)
			}).catch(function (error) {
			    console.log(error)
			})
		}); */

		/* $(function() {
			service({
				url : $GV.ROOT + "/test/users/object",
				method : "post",
				data : {"id":333333333,"username":"username999999"}
			}).then(function(res) {
				console.log(res)
			}).catch(function (error) {
			    console.log(error)
			})
		}); */
		/* $(function() {
			var paramsObject = {
				"id" : "99999999",
				"username" : "99999username99999999"
			};
			service({
				url : $GV.ROOT + "/test/users",
				method : "post",
				data : makeUpURIParams(paramsObject)
			}).then(function(res) {
				console.log(res)
			}).catch(function (error) {
			    console.log(error)
			})
		}); */

		function makeUpURIParams(obj) {
			var _URIParams = "";
			if (obj) {
				Object.keys(obj).map(function(key) {
					if (_URIParams && _URIParams.length > 0) {
						_URIParams += "&";
					}
					_URIParams += key + '=' + obj[key];
				})
			}
			return _URIParams;
		}
	</script>
</body>
</html>