package com.binarybricks.coiny.adapterdelegates

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binarybricks.coiny.components.DashboardEmptyCardModule
import com.binarybricks.coiny.components.ModuleItem
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import kotlinx.android.extensions.LayoutContainer


/**
 * Created by Pranay Airan
 */

class DashboardEmptyCardAdapterDelegate : AdapterDelegate<List<ModuleItem>>() {

    override fun isForViewType(items: List<ModuleItem>, position: Int): Boolean {
        return items[position] is DashboardEmptyCardModule.DashboardEmptyCardModuleData
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val dashboardEmptyCardModule = DashboardEmptyCardModule()
        val dashboardEmptyCardModuleView = dashboardEmptyCardModule.init(LayoutInflater.from(parent.context), parent)
        return DashboardEmptyCardViewHolder(dashboardEmptyCardModuleView, dashboardEmptyCardModule)
    }

    override fun onBindViewHolder(items: List<ModuleItem>, position: Int, holder: RecyclerView.ViewHolder, payloads: List<Any>) {
        val dashboardEmptyCardViewHolder = holder as DashboardEmptyCardViewHolder
        dashboardEmptyCardViewHolder.showTextInEmptySpace((items[position] as DashboardEmptyCardModule.DashboardEmptyCardModuleData))
    }

    class DashboardEmptyCardViewHolder(override val containerView: View, private val dashboardEmptyCardModule: DashboardEmptyCardModule)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun showTextInEmptySpace(dashboardEmptyCardModuleData: DashboardEmptyCardModule.DashboardEmptyCardModuleData) {
            dashboardEmptyCardModule.showTextInEmptySpace(itemView, dashboardEmptyCardModuleData)
        }
    }
}