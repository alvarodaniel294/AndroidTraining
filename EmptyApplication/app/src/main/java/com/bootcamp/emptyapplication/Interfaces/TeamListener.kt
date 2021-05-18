package com.bootcamp.emptyapplication.Interfaces

import com.bootcamp.emptyapplication.Models.Team

interface TeamListener {
    fun onViewTeamDetailTap(Team: Team)
}