<nav class="sidebar sidebar-offcanvas" id="sidebar"
	style="margin-top: 46px; border-radius: 0px;">
	<ul class="nav">
		<%-- <li class="nav-item"><a class="nav-link" data-toggle="collapse"
			href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
				<i class="typcn typcn-document-text menu-icon"></i> <span
				class="menu-title">File template</span> <i class="menu-arrow"></i>
			</a>
			<div class="collapse" id="ui-basic">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/list-file-template">List template</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/file-template">Create template</a></li>
				</ul>
			</div>
		</li> --%>

		<li class="nav-item">
			<a class="nav-link"
			href="<%=request.getContextPath()%>/list-file-template">
				<i class="fa fa-files-o menu-icon"></i> <span
				class="menu-title">List template</span>
			</a>
		</li>

		<li class="nav-item">
			<a class="nav-link"
			href="<%=request.getContextPath()%>/file-template">
				<i class="fa fa-file-o menu-icon"></i> <span
				class="menu-title">Create template</span>
			</a>
		</li>	

		<li class="nav-item">
			<a class="nav-link"
			href="<%=request.getContextPath()%>/generate-dataset-column-model">
				<i class="fa fa-columns menu-icon"></i> <span
				class="menu-title">Dataset & Column model</span>
			</a>
		</li>

		<li class="nav-item">
			<a class="nav-link"
			href="<%=request.getContextPath()%>/generate-file-name-sql">
				<i class="fa fa-magic menu-icon"></i> <span
				class="menu-title">File name sql</span>
			</a>
		</li>

		<li class="nav-item"><a class="nav-link" data-toggle="collapse"
			href="#ui-cm-message" aria-expanded="false" aria-controls="ui-cm-message">
				<i class="fa fa-file-text-o menu-icon"></i> <span
				class="menu-title">Cm message</span> <i class="menu-arrow"></i>
			</a>
			<div class="${true ? '' : 'collapse'}" id="ui-cm-message">
				<ul class="nav flex-column sub-menu">
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/generate-cm-message-nexthr-core">For NextHR-Core</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/generate-cm-message-hr-core">For HR-Core</a></li>
				</ul>
			</div>
		</li>

		<li class="nav-item">
			<a class="nav-link" target="_blank"
			href="<%=request.getContextPath()%>/swagger-ui.html">
				<i class="fa fa-credit-card menu-icon"></i> <span
				class="menu-title">Swagger-ui API</span>
			</a>
		</li>

		<li class="nav-item">
			<a class="nav-link"
			href="<%=request.getContextPath()%>/database">
				<i class="fa fa-database menu-icon"></i> <span
				class="menu-title">Database</span>
			</a>
		</li>

		<li class="nav-item">
			<a class="nav-link"
			href="<%=request.getContextPath()%>/setting">
				<i class="fa fa-cogs menu-icon"></i><span
				class="menu-title">Setting</span>
			</a>
		</li>

	</ul>
</nav>