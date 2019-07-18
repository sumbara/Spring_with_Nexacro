(function()
{
	return function()
	{
		nexacro._setCSSMaps(
		{
			"Static" :
			{
				"self" :
				{
					"enabled" :
					{
						"font" : nexacro.FontObject("normal 700 20pt/normal \"LG스마트체 Bold\"")
					}
				},
				"class" :
				{
					"st_content" :
					{
						"self" :
						{
							"enabled" :
							{
								"font" : nexacro.FontObject("normal 13pt /normal \"LG스마트체 SemiBold\"")
							}
						}
					}
				}
			},
			"Button" :
			{
				"class" :
				{
					"bt_search" :
					{
						"self" :
						{
							"enabled" :
							{
								"font" : nexacro.FontObject("normal 15pt /normal \"LG스마트체 SemiBold\""),
								"color" : nexacro.ColorObject("#ffffff"),
								"border" : nexacro.BorderObject("0px none #5AAEFF")
							},
							"mouseover" :
							{
								"font" : nexacro.FontObject("normal 15pt /normal \"LG스마트체 SemiBold\""),
								"color" : nexacro.ColorObject("#ffffff"),
								"border" : nexacro.BorderObject("0px none #5AAEFF")
							},
							"focused" :
							{
								"font" : nexacro.FontObject("normal 15pt /normal \"LG스마트체 SemiBold\""),
								"color" : nexacro.ColorObject("#ffffff"),
								"border" : nexacro.BorderObject("0px none #5AAEFF")
							},
							"pushed" :
							{
								"font" : nexacro.FontObject("normal 15pt /normal \"LG스마트체 SemiBold\""),
								"color" : nexacro.ColorObject("#ffffff"),
								"border" : nexacro.BorderObject("0px none #5AAEFF")
							},
							"selected" :
							{
								"font" : nexacro.FontObject("normal 15pt /normal \"LG스마트체 SemiBold\""),
								"color" : nexacro.ColorObject("#ffffff"),
								"border" : nexacro.BorderObject("0px none #5AAEFF")
							}
						}
					},
					"bt_click" :
					{
						"self" :
						{
							"enabled" :
							{
								"font" : nexacro.FontObject("normal 13pt /normal \"LG스마트체 SemiBold\""),
								"color" : nexacro.ColorObject("#ffffff"),
								"border" : nexacro.BorderObject("0px none #a5a5a5")
							},
							"mouseover" :
							{
								"font" : nexacro.FontObject("normal 13pt /normal \"LG스마트체 SemiBold\""),
								"color" : nexacro.ColorObject("#ffffff"),
								"border" : nexacro.BorderObject("0px none #a5a5a5")
							},
							"focused" :
							{
								"font" : nexacro.FontObject("normal 13pt /normal \"LG스마트체 SemiBold\""),
								"color" : nexacro.ColorObject("#ffffff"),
								"border" : nexacro.BorderObject("0px none #a5a5a5")
							},
							"pushed" :
							{
								"font" : nexacro.FontObject("normal 13pt /normal \"LG스마트체 SemiBold\""),
								"color" : nexacro.ColorObject("#ffffff"),
								"border" : nexacro.BorderObject("0px none #a5a5a5")
							},
							"selected" :
							{
								"font" : nexacro.FontObject("normal 13pt /normal \"LG스마트체 SemiBold\""),
								"color" : nexacro.ColorObject("#ffffff"),
								"border" : nexacro.BorderObject("0px none #a5a5a5")
							}
						}
					}
				}
			},
			"treeitemimage" :
			{
				"parent" :
				{
					"celltreeitem" :
					{
						"parent" :
						{
							"cell" :
							{
								"class" :
								{
									"main_grid" :
									{
										"parent" :
										{
											"row" :
											{
												"parent" :
												{
													"body" :
													{
														"parent" :
														{
															"Grid" :
															{
																"self" :
																{
																	"enabled" :
																	{
																		"icon" : nexacro.UrlObject("URL(\"theme://images/img_WF_Grdimg.png\")")
																	},
																	"expand" :
																	{
																		"icon" : nexacro.UrlObject("URL(\"theme://images/btn_WF_Popmenunext_D.png\")")
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		);

		var imgcache = nexacro._getImageCacheMaps();
		
	};
}
)();
